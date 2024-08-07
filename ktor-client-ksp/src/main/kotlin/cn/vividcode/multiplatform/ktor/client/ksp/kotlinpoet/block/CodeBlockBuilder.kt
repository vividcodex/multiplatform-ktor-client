package cn.vividcode.multiplatform.ktor.client.ksp.kotlinpoet.block

import cn.vividcode.multiplatform.ktor.client.ksp.expends.classNames
import cn.vividcode.multiplatform.ktor.client.ksp.model.structure.FunStructure
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.TypeName

/**
 * 项目：vividcode-multiplatform-ktor-client
 *
 * 作者：li-jia-wei
 *
 * 创建：2024/7/4 下午11:31
 *
 * 介绍：CodeBlockBuilder
 */
internal sealed class CodeBlockBuilder(
	private val funStructure: FunStructure,
	private val addImport: (String, Array<out String>) -> Unit
) {
	
	abstract fun CodeBlock.Builder.buildCodeBlock()
	
	protected fun addImport(packageName: String, vararg simpleNames: String) {
		this.addImport(packageName, simpleNames)
	}
	
	protected fun addImport(typeName: TypeName) {
		when (typeName) {
			is ClassName -> addImport(typeName.packageName, typeName.simpleName)
			is ParameterizedTypeName -> addImports(typeName.classNames)
			else -> {}
		}
	}
	
	protected fun addImports(classNames: List<ClassName>) {
		classNames.forEach {
			addImport(it.packageName, it.simpleName)
		}
	}
	
	protected fun getVarName(varName: String): String {
		var realVarName = varName
		var num = 1
		while (funStructure.valueParameterModels.any { it.varName == varName }) {
			realVarName = varName + num++
		}
		return realVarName
	}
}