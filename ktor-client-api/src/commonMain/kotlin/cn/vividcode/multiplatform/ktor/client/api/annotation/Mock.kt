package cn.vividcode.multiplatform.ktor.client.api.annotation

import cn.vividcode.multiplatform.ktor.client.api.builder.mock.MOCK_DEFAULT_NAME

/**
 * 项目：vividcode-multiplatform-ktor-client
 *
 * 作者：li-jia-wei
 *
 * 创建：2024/7/1 上午10:23
 *
 * 介绍：Mock
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class Mock(
	val name: String = MOCK_DEFAULT_NAME
)