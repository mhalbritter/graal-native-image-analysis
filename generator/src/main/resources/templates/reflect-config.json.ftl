<#-- @ftlvariable name="model" type="generator.model.ReflectConfigModel" -->
[
<#list 0 ..< model.numberOfClasses as i>
	{
		"name": "simplereflection.manyclasses.classes.Class${i}",
		"methods": [
			{
				"name": "<init>",
				"parameterTypes": []
			},
    <#list 0 ..< model.methodsPerClass as j>
			{
				"name": "print${j}",
				"parameterTypes": []
			},
    </#list>
		]
	},
</#list>
]
