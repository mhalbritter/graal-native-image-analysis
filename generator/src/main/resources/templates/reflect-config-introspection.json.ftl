<#-- @ftlvariable name="model" type="generator.model.ReflectConfigModel" -->
[
<#list 0 ..< model.numberOfClasses as i>
	{
	"name": "reflectionintrospectionplot.classes.Class${i}",
	"queriedMethods" : [
    <#list 0 ..< model.methodsPerClass as j>
		{
		"name": "method${j}"
		}<#if j?has_next >,</#if>
    </#list>
	]
	}<#if i?has_next >,</#if>
</#list>
]
