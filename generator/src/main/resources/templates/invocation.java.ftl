<#-- @ftlvariable name="model" type="generator.model.InvocationModel" -->

public static void main(String[] args) {
<#list 0 ..< model.numberOfClasses as i>
	Class${i} class${i} = new Class${i}();
	<#list 0 ..< model.methodsPerClass as j>
	class${i}.print${j}();
	</#list>

</#list>
}
