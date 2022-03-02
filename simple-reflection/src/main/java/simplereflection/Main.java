package simplereflection;

import java.lang.reflect.Method;

/**
 * Uses the reflection api without querying, just for invokes.
 *
 * @author Moritz Halbritter
 */
class Main {
	public static void main(String[] args) throws Exception {
		Object helloWorldPrinter = Class.forName("simplereflection.HelloWorldPrinter").getDeclaredConstructor().newInstance();
		Method sayHello = helloWorldPrinter.getClass().getDeclaredMethod("sayHello");
		sayHello.invoke(helloWorldPrinter);
	}
}
