# Reflection introspection plot

Data for the chart which shows executable size in relation to included method introspection metadata
in `reflect-config.json`.

For the [raw data see here](reflection-introspection-plot.ods).

## Code

The included classes are of this form:

```java
public class Class0 {

	@TestAnnotation("Class0.method0")
	public void method0() {

	}

	@TestAnnotation("Class0.method1")
	public void method1() {

	}
	// more methods
}
```

## 0 methods

```
   3,98MB (33,36%) for code area:    7.384 compilation units
   6,92MB (58,03%) for image heap:   1.633 classes and 90.776 objects
   1,03MB ( 8,61%) for other data
  11,92MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 635,08KB java.util                                            1,75MB byte[] for general heap data
 310,50KB java.lang                                          790,88KB java.lang.String
 265,80KB java.text                                          587,38KB java.lang.Class
 235,43KB java.util.regex                                    487,39KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 418,97KB java.util.HashMap$Node
 177,07KB java.util.concurrent                               220,47KB java.util.HashMap$Node[]
 143,38KB java.math                                          154,69KB java.util.concurrent.ConcurrentHashMap$Node
 120,52KB com.oracle.svm.core.reflect                        147,05KB java.lang.String[]
  94,21KB java.util.logging                                  143,73KB char[]
  92,03KB java.util.stream                                   139,85KB sun.util.locale.LocaleObjectCache$CacheEntry
      ... 115 additional packages                                 ... 764 additional object types   
```

## 1 method

```
   4,11MB (33,93%) for code area:    7.668 compilation units
   6,95MB (57,30%) for image heap:   1.708 classes and 96.679 objects
   1,06MB ( 8,77%) for other data
  12,12MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,13KB java.util                                            1,81MB byte[] for general heap data
 312,79KB java.lang                                          829,50KB java.lang.String
 265,80KB java.text                                          631,52KB java.lang.Class
 235,43KB java.util.regex                                    500,47KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 421,41KB java.util.HashMap$Node
 177,51KB java.util.concurrent                               221,61KB java.util.HashMap$Node[]
 143,38KB java.math                                          154,73KB java.util.concurrent.ConcurrentHashMap$Node
 122,07KB com.oracle.svm.core.reflect                        149,91KB java.lang.String[]
 101,14KB java.util.stream                                   143,73KB char[]
  94,21KB java.util.logging                                  139,85KB sun.util.locale.LocaleObjectCache$CacheEntry
      ... 125 additional packages                                 ... 799 additional object types
```

## 2 methods

```

```

## 4 methods

```

```

## 8 methods

```

```

## 16 methods

```

```

## 32 methods

```

```

## 64 methods

```

```

## 128 methods

```

```

## 256 methods

```

```

## 512 methods

```
   4,11MB (33,93%) for code area:    7.668 compilation units
   6,95MB (57,30%) for image heap:   1.708 classes and 98.722 objects
   1,06MB ( 8,77%) for other data
  12,12MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,00KB java.util                                            1,83MB byte[] for general heap data
 312,78KB java.lang                                          861,44KB java.lang.String
 265,80KB java.text                                          631,52KB java.lang.Class
 235,43KB java.util.regex                                    512,73KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 421,41KB java.util.HashMap$Node
 177,50KB java.util.concurrent                               221,61KB java.util.HashMap$Node[]
 143,38KB java.math                                          157,90KB java.lang.String[]
 122,07KB com.oracle.svm.core.reflect                        154,73KB java.util.concurrent.ConcurrentHashMap$Node
 101,13KB java.util.stream                                   143,73KB char[]
  94,21KB java.util.logging                                  139,85KB sun.util.locale.LocaleObjectCache$CacheEntry
      ... 125 additional packages                                 ... 799 additional object types
```

## 1024 methods

```
   4,11MB (33,93%) for code area:    7.668 compilation units
   6,95MB (57,30%) for image heap:   1.708 classes and 100.770 objects
   1,06MB ( 8,77%) for other data
  12,12MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,13KB java.util                                            1,85MB byte[] for general heap data
 312,79KB java.lang                                          893,44KB java.lang.String
 265,80KB java.text                                          631,52KB java.lang.Class
 235,43KB java.util.regex                                    525,28KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 421,41KB java.util.HashMap$Node
 177,51KB java.util.concurrent                               221,61KB java.util.HashMap$Node[]
 143,38KB java.math                                          165,90KB java.lang.String[]
 122,07KB com.oracle.svm.core.reflect                        154,73KB java.util.concurrent.ConcurrentHashMap$Node
 101,13KB java.util.stream                                   143,73KB char[]
  94,21KB java.util.logging                                  139,85KB sun.util.locale.LocaleObjectCache$CacheEntry
      ... 125 additional packages                                 ... 799 additional object types
```

## 2048 methods

```
   4,11MB (33,93%) for code area:    7.668 compilation units
   6,95MB (57,30%) for image heap:   1.708 classes and 104.862 objects
   1,06MB ( 8,77%) for other data
  12,12MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,13KB java.util                                            1,89MB byte[] for general heap data
 312,78KB java.lang                                          957,44KB java.lang.String
 265,80KB java.text                                          631,52KB java.lang.Class
 235,43KB java.util.regex                                    552,28KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 421,41KB java.util.HashMap$Node
 177,51KB java.util.concurrent                               221,61KB java.util.HashMap$Node[]
 143,38KB java.math                                          181,90KB java.lang.String[]
 122,07KB com.oracle.svm.core.reflect                        154,73KB java.util.concurrent.ConcurrentHashMap$Node
 101,13KB java.util.stream                                   143,73KB char[]
  94,21KB java.util.logging                                  140,74KB byte[] for method metadata
      ... 125 additional packages                                 ... 799 additional object types
```

## 4096 methods

```
   4,11MB (33,41%) for code area:    7.668 compilation units
   7,13MB (57,95%) for image heap:   1.708 classes and 113.057 objects
   1,06MB ( 8,63%) for other data
  12,31MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,13KB java.util                                            1,98MB byte[] for general heap data
 312,79KB java.lang                                            1,06MB java.lang.String
 265,80KB java.text                                          631,52KB java.lang.Class
 235,43KB java.util.regex                                    606,28KB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 421,41KB java.util.HashMap$Node
 177,51KB java.util.concurrent                               221,61KB java.util.HashMap$Node[]
 143,38KB java.math                                          213,90KB java.lang.String[]
 122,07KB com.oracle.svm.core.reflect                        204,74KB byte[] for method metadata
 101,14KB java.util.stream                                   154,73KB java.util.concurrent.ConcurrentHashMap$Node
  94,21KB java.util.logging                                  143,73KB char[]
      ... 125 additional packages                                 ... 799 additional object types
```

## 8192 methods

```
   4,11MB (30,24%) for code area:    7.668 compilation units
   8,43MB (61,95%) for image heap:   1.708 classes and 129.441 objects
   1,06MB ( 7,81%) for other data
  13,60MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,05KB java.util                                            2,15MB byte[] for general heap data
 312,78KB java.lang                                            1,31MB java.lang.String
 265,80KB java.text                                          714,28KB byte[] for java.lang.String
 235,43KB java.util.regex                                    631,52KB java.lang.Class
 200,68KB com.oracle.svm.jni                                 421,41KB java.util.HashMap$Node
 177,51KB java.util.concurrent                               332,74KB byte[] for method metadata
 143,38KB java.math                                          277,90KB java.lang.String[]
 122,07KB com.oracle.svm.core.reflect                        221,61KB java.util.HashMap$Node[]
 101,13KB java.util.stream                                   154,73KB java.util.concurrent.ConcurrentHashMap$Node
  94,21KB java.util.logging                                  143,73KB char[]
      ... 125 additional packages                                 ... 799 additional object types
```

## 16384 methods

```
   4,11MB (27,46%) for code area:    7.668 compilation units
   9,80MB (65,44%) for image heap:   1.708 classes and 162.210 objects
   1,06MB ( 7,10%) for other data
  14,98MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,13KB java.util                                            2,49MB byte[] for general heap data
 312,79KB java.lang                                            1,81MB java.lang.String
 265,80KB java.text                                          942,75KB byte[] for java.lang.String
 235,43KB java.util.regex                                    631,52KB java.lang.Class
 200,68KB com.oracle.svm.jni                                 588,75KB byte[] for method metadata
 177,51KB java.util.concurrent                               421,41KB java.util.HashMap$Node
 143,38KB java.math                                          405,90KB java.lang.String[]
 122,07KB com.oracle.svm.core.reflect                        221,61KB java.util.HashMap$Node[]
 101,14KB java.util.stream                                   154,73KB java.util.concurrent.ConcurrentHashMap$Node
  94,21KB java.util.logging                                  143,73KB char[]
      ... 125 additional packages                                 ... 799 additional object types
```

## 32768 methods (split to 2 classes)

```
   4,11MB (24,77%) for code area:    7.668 compilation units
  11,43MB (68,82%) for image heap:   1.708 classes and 194.983 objects
   1,06MB ( 6,40%) for other data
  16,60MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,05KB java.util                                            2,84MB byte[] for general heap data
 312,78KB java.lang                                            2,31MB java.lang.String
 265,80KB java.text                                            1,19MB byte[] for java.lang.String
 235,43KB java.util.regex                                      1,07MB byte[] for method metadata
 200,68KB com.oracle.svm.jni                                 631,73KB java.lang.Class
 177,51KB java.util.concurrent                               533,91KB java.lang.String[]
 143,38KB java.math                                          421,41KB java.util.HashMap$Node
 122,07KB com.oracle.svm.core.reflect                        221,61KB java.util.HashMap$Node[]
 101,13KB java.util.stream                                   154,73KB java.util.concurrent.ConcurrentHashMap$Node
  94,21KB java.util.logging                                  143,73KB char[]
      ... 125 additional packages                                 ... 799 additional object types
```

## 65536 methods (split to 4 classes)

```
   4,11MB (20,72%) for code area:    7.668 compilation units
  14,67MB (73,92%) for image heap:   1.708 classes and 260.535 objects
   1,06MB ( 5,36%) for other data
  19,85MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,05KB java.util                                            3,53MB byte[] for general heap data
 312,78KB java.lang                                            3,31MB java.lang.String
 265,80KB java.text                                            2,07MB byte[] for method metadata
 235,43KB java.util.regex                                      1,73MB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                 789,92KB java.lang.String[]
 177,51KB java.util.concurrent                               632,13KB java.lang.Class
 143,38KB java.math                                          421,41KB java.util.HashMap$Node
 122,07KB com.oracle.svm.core.reflect                        221,61KB java.util.HashMap$Node[]
 101,13KB java.util.stream                                   154,73KB java.util.concurrent.ConcurrentHashMap$Node
  94,21KB java.util.logging                                  143,73KB char[]
      ... 125 additional packages                                 ... 799 additional object types
```

## 131072 methods (split to 8 classes)

```
   4,11MB (15,05%) for code area:    7.668 compilation units
  22,16MB (81,06%) for image heap:   1.708 classes and 391.633 objects
   1,06MB ( 3,89%) for other data
  27,33MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 packages in code area:                               Top 10 object types in image heap:
 641,13KB java.util                                            5,31MB java.lang.String
 312,78KB java.lang                                            4,92MB byte[] for general heap data
 265,80KB java.text                                            4,05MB byte[] for method metadata
 235,43KB java.util.regex                                      2,82MB byte[] for java.lang.String
 200,68KB com.oracle.svm.jni                                   1,27MB java.lang.String[]
 177,51KB java.util.concurrent                               632,95KB java.lang.Class
 143,38KB java.math                                          421,41KB java.util.HashMap$Node
 122,07KB com.oracle.svm.core.reflect                        221,61KB java.util.HashMap$Node[]
 101,13KB java.util.stream                                   154,73KB java.util.concurrent.ConcurrentHashMap$Node
  94,21KB java.util.logging                                  143,73KB char[]
      ... 125 additional packages                                 ... 799 additional object types
```
