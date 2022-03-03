package reflectionintrospectionplot;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Moritz Halbritter
 */
class Main {
	public static final int NUMBER_OF_CLASSES = 8;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			Class<?> clazz = Class.forName("reflectionintrospectionplot.classes.Class" +  i);

			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			System.out.println("Constructors:");
			for (Constructor<?> constructor : constructors) {
				System.out.println("\t" + constructor);
				System.out.println();
			}

			Method[] methods = clazz.getDeclaredMethods();
			System.out.println("Methods:");
			for (Method method : methods) {
				System.out.println("\t" + method);

				Annotation[] annotations = method.getDeclaredAnnotations();
				System.out.println("\tAnnotations:");
				for (Annotation annotation : annotations) {
					System.out.println("\t\t" + annotation);
				}
				System.out.println();
			}
		}
	}
}
