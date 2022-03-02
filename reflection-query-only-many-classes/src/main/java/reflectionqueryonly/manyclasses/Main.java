package reflectionqueryonly.manyclasses;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Moritz Halbritter
 */
class Main {
	private static final int NUMBER_CLASSES = 100;

	public static void main(String[] args) throws Exception {
		System.out.println();
		for (int i = 0; i < NUMBER_CLASSES; i++) {
			Class<?> clazz = Class.forName(String.format("reflectionqueryonly.manyclasses.classes.Class%d", i));
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method);
			}
			System.out.println();
		}
	}
}
