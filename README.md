# Graal benchmarks

## Learnings

* Image size doesn't increase when including methods called through reflection
  * Compare `no-reflection` and `simple-reflection`
* Image size increases a bit when including reflection query data
  * Compare `simple-reflection` and `reflection-query`
  * This amounts to 256 KB executable size when including reflection query data for 100 classes with 1 constructor and 100 methods each (10100 methods in total)
* If only reflection querying is used and not invocation, native-image is clever enough to only include the reflection metadata and not the code for the reflected class/method
  * Search for `HelloWorldPrinter` in "Used Classes" report from Graal in `reflection-query-only`
* native-image uses padding (or method inlining?)
  * Binary size for `no-reflection` and `no-reflection-many-classes` is the same
* Even generating the `ReflectionAccessorHolder` for many classes doesn't increase size significantly
  * Compare binary size for `simple-reflection-many-classes` methods with `no-reflection-many-classes`
* When including reflection invoke in `reflect-config.json` for methods which are not called at runtime, native-image adds the code to the executable
  * This was expected and can bloat the executable with dead code
* When using many classes with many methods, the reflection based executable is twice as big as the one without reflection
  * Compare `no-reflection-many-big-classes` with `simple-reflection-many-big-classes`: 15,6 MB vs 31,0 MB

## Analysis of executable size

You can use the [GraalVM dashboard](https://www.graalvm.org/dashboard/?ojr=dashboard) to analyze the contents of an executable. This dashboards reads a `bgv` file, which can be generated
in the native build using the `-H:DashboardDump=filename -H:+DashboardHeap -H:+DashboardCode` parameters.

### no-reflection-many-big-classes vs simple-reflection-many-big-classes

`no-reflection-many-big-classes`:

```
   7,14MB (41,50%) for code area:   17.375 compilation units
   8,26MB (47,99%) for image heap:   1.733 classes and 111.656 objects
   1,81MB (10,50%) for other data
  17,21MB in total
  
Top 10 packages in code area:                               Top 10 object types in image heap:
   3,01MB noreflection.manyclasses.big.classes                 3,21MB byte[] for general heap data
 634,03KB java.util                                            1,09MB java.lang.String
 310,50KB java.lang                                          657,67KB byte[] for java.lang.String
 265,80KB java.text                                          609,64KB java.lang.Class
 235,43KB java.util.regex                                    418,97KB java.util.HashMap$Node
 200,68KB com.oracle.svm.jni                                 226,73KB java.lang.String[]
 176,75KB java.util.concurrent                               220,47KB java.util.HashMap$Node[]
 143,38KB java.math                                          154,69KB java.util.concurrent.ConcurrentHashMap$Node
 125,85KB noreflection.manyclasses.big                       143,73KB char[]
 120,52KB com.oracle.svm.core.reflect                        139,85KB sun.util.locale.LocaleObjectCache$CacheEntry
      ... 116 additional packages                                 ... 764 additional object types  
```

`simple-reflection-many-big-classes`:

```
   8,88MB (25,92%) for code area:   27.477 compilation units
  21,91MB (63,99%) for image heap:   1.733 classes and 324.067 objects
   3,45MB (10,08%) for other data
  34,24MB in total
  
Top 10 packages in code area:                               Top 10 object types in image heap:
   3,01MB simplereflection.manyclasses.big.classes             3,75MB java.util.LinkedHashMap
   1,89MB com.oracle.svm.core.reflect                          3,74MB byte[] for general heap data
 634,11KB java.util                                            3,70MB java.lang.reflect.Method
 312,30KB java.lang                                            2,50MB s.r.a.AnnotatedTypeFactory$AnnotatedTypeBaseImpl
 265,80KB java.text                                            1,40MB java.lang.String
 235,43KB java.util.regex                                      1,18MB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 641,77KB java.lang.reflect.AnnotatedType[]
 176,75KB java.util.concurrent                               609,64KB java.lang.Class
 143,38KB java.math                                          418,97KB java.util.HashMap$Node
  94,21KB java.util.logging                                  343,15KB java.lang.Class[]
      ... 116 additional packages                                 ... 764 additional object types  
```

![](img/no-reflection-many-big-classes-code.png)

The no reflection version contains 3 MB of our code, and 931 KB of `com.oracle` code, which is GraalVM specific code.

![](img/simple-reflection-many-big-classes-code.png)

The reflection version contains the same 3 MB of our code, but the `com.oracle` code is much bigger (3 MB vs. 931 KB). When digging deeper into this package,
we find 2 MB of `com.oracle.svm.core.reflect` code, which is only 123 KB in size in the `no-reflection-many-big-classes` dump. The majority of this 2 MB is
`ReflectionAccessorHolder`, which is the code Graal generates for reflection access.

![](img/no-reflection-many-big-classes-heap.png)

This image shows a visualization of the heap contents which are embedded in the executable.

![](img/simple-reflection-many-big-classes-heap.png)

When comparing the reflection heap with the no reflection heap, we can see that it's a lot bigger. That's the main reason
why the reflection image is bigger. We can see 4 MB of `LinkedHashMap`, which is not in the no reflection version. Another
4 MB of the heap is used for `reflect.Method`, which is also not there in the no reflection version. Another 3 MB are spent
for `sun.reflect.annotation` data, which is also not in the no reflection version.

### no-reflection-many-classes vs simple-reflection-many-classes

`no-reflection-many-classes`:

```
   4,01MB (33,46%) for code area:    7.475 compilation units  
   6,93MB (57,82%) for image heap:   1.733 classes and 91.653 objects
   1,04MB ( 8,72%) for other data
  11,98MB in total

Top 10 packages in code area:                               Top 10 object types in image heap:
 634,10KB java.util                                            1,77MB byte[] for general heap data
 310,51KB java.lang                                          800,09KB java.lang.String
 265,80KB java.text                                          609,64KB java.lang.Class
 235,43KB java.util.regex                                    494,10KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 418,97KB java.util.HashMap$Node
 176,75KB java.util.concurrent                               220,47KB java.util.HashMap$Node[]
 143,38KB java.math                                          154,69KB java.util.concurrent.ConcurrentHashMap$Node
 120,52KB com.oracle.svm.core.reflect                        148,62KB java.lang.String[]
  94,21KB java.util.logging                                  143,73KB char[]
  92,03KB java.util.stream                                   139,85KB sun.util.locale.LocaleObjectCach
      ... 116 additional packages                                 ... 764 additional object types  
```

`simple-reflection-many-classes`:

```
   4,04MB (33,54%) for code area:    7.677 compilation units
   6,93MB (57,52%) for image heap:   1.733 classes and 96.068 objects
   1,08MB ( 8,94%) for other data
  12,05MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 634,11KB java.util                                            1,78MB byte[] for general heap data
 312,30KB java.lang                                          806,47KB java.lang.String
 265,80KB java.text                                          609,64KB java.lang.Class
 235,43KB java.util.regex                                    505,77KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 418,97KB java.util.HashMap$Node
 176,75KB java.util.concurrent                               220,47KB java.util.HashMap$Node[]
 158,80KB com.oracle.svm.core.reflect                        154,69KB java.util.concurrent.ConcurrentHashMap$Node
 143,38KB java.math                                          150,20KB java.lang.String[]
  94,21KB java.util.logging                                  143,73KB char[]
  92,03KB java.util.stream                                   139,85KB sun.util.locale.LocaleObjectCache$CacheEntry
      ... 116 additional packages                                 ... 764 additional object types
```

The images are of the same size, as the generated reflection code from Graal for 100 methods (100 classes with 1 method each) isn't that much compared the base infrastructure which is included in every executable. 

## Open experiments

* Which is better? Many small classes or few big classes?
  * Both reflection / no reflection
