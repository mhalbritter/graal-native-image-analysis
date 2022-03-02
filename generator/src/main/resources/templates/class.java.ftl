<#-- @ftlvariable name="model" type="generator.model.ClassModel" -->

package simplereflection.classes10k.classes;

public class Class${model.classNo} {

<#list 0 ..< model.numberOfMethods as i>
	public void print${i}() {
		System.out.println("Class${model.classNo}.print${i}()");
		System.out.println("  ________                    .______   _________   ");
		System.out.println(" /  _____/___________  _____  |  \\   \\ /   /     \\  ");
		System.out.println("/   \\  __\\_  __ \\__  \\ \\__  \\ |  |\\   Y   /  \\ /  \\ ");
		System.out.println("\\    \\_\\  \\  | \\// __ \\_/ __ \\|  |_\\     /    Y    \\");
		System.out.println(" \\______  /__|  (____  (____  /____/\\___/\\____|__  /");
		System.out.println("        \\/           \\/     \\/                   \\/ ");
	}
</#list>

}
