package reflectionquery;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Uses the reflection api to query declared constructors and methods and then invoke them.
 *
 * @author Moritz Halbritter
 */
class Main {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("reflectionquery.HelloWorldPrinter");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		Object helloWorldPrinter = null;
		for (Constructor<?> constructor : constructors) {
			if (constructor.getParameterCount() == 0) {
				helloWorldPrinter = constructor.newInstance();
				break;
			}
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals("sayHello")) {
				method.invoke(helloWorldPrinter);
			}
		}
	}
}
