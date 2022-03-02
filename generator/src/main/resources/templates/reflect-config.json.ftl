<#-- @ftlvariable name="model" type="generator.model.ReflectConfigModel" -->
[
<#list 0 ..< model.numberOfClasses as i>
	{
		"name": "reflectionplot.classes.Class${i}",
		"methods": [
			{
				"name": "<init>",
				"parameterTypes": []
			},
    <#list 0 ..< model.methodsPerClass as j>
			{
				"name": "print${j}",
				"parameterTypes": []
			}<#if j?has_next >,</#if>
    </#list>
		]
	}<#if i?has_next >,</#if>
</#list>
]
