package simplereflection.manyclasses.big;

/**
 * @author Moritz Halbritter
 */
class Main {

	public static final int NUMBER_OF_CLASSES = 100;

	private static final int METHODS_PER_CLASS = 100;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < NUMBER_OF_CLASSES; i++) {
			Class<?> clazz = Class.forName(String.format("simplereflection.manyclasses.big.classes.Class%d", i));
			Object instance = clazz.getDeclaredConstructor().newInstance();
			for (int j = 0; j < METHODS_PER_CLASS; j++) {
				clazz.getDeclaredMethod("print" + j).invoke(instance);
			}
		}
	}
}
