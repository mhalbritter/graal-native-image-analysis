package generator.model;

/**
 * @author Moritz Halbritter
 */
public class InvocationModel {
	private final int numberOfClasses;
	private final int methodsPerClass;

	public InvocationModel(int numberOfClasses, int methodsPerClass) {
		this.numberOfClasses = numberOfClasses;
		this.methodsPerClass = methodsPerClass;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public int getMethodsPerClass() {
		return methodsPerClass;
	}
}
