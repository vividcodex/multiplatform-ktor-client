package cn.vividcode.multiplatform.ktor.client.api.builder.mock

/**
 * 项目：vividcode-multiplatform-ktor-client
 *
 * 作者：li-jia-wei
 *
 * 创建：2024/7/1 上午10:33
 *
 * 介绍：MockModel
 */
data class MockModel<T : Any> internal constructor(
	val durationRange: DurationRange,
	val result: T
)