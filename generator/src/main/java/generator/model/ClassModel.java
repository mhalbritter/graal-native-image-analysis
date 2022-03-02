package generator.model;

/**
 * @author Moritz Halbritter
 */
public class ClassModel {
	private final int classNo;
	private final int numberOfMethods;

	public ClassModel(int classNo, int numberOfMethods) {
		this.classNo = classNo;
		this.numberOfMethods = numberOfMethods;
	}

	public int getClassNo() {
		return classNo;
	}

	public int getNumberOfMethods() {
		return numberOfMethods;
	}
}
