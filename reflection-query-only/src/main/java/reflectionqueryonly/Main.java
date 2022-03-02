package reflectionqueryonly;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Uses the reflection api to query declared constructors and methods.
 *
 * @author Moritz Halbritter
 */
class Main {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("reflectionqueryonly.HelloWorldPrinter");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}
