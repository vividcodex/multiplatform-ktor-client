package cn.vividcode.multiplatform.ktor.client.api.annotation

import cn.vividcode.multiplatform.ktor.client.api.ApiScope
import kotlin.reflect.KClass

/**
 * 项目：vividcode-multiplatform
 *
 * 作者：li-jia-wei
 *
 * 创建：2024/3/23 21:06
 *
 * 介绍：Api
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class Api(
	val url: String = "",
	val apiScope: KClass<out ApiScope> = ApiScope::class
)