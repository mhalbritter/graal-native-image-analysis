package noreflection;

/**
 * Does not use the reflection api.
 *
 * @author Moritz Halbritter
 */
class Main {
	public static void main(String[] args) {
		HelloWorldPrinter printer = new HelloWorldPrinter();
		printer.sayHello();
	}
}
