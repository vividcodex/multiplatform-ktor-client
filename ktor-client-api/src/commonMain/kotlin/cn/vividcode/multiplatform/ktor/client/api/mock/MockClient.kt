package cn.vividcode.multiplatform.ktor.client.api.mock

import cn.vividcode.multiplatform.ktor.client.api.mock.plugin.MockClientPlugin

/**
 * 项目：vividcode-multiplatform-ktor-client
 *
 * 作者：li-jia-wei
 *
 * 创建：2024/7/6 下午5:43
 *
 * 介绍：MockClient
 */
@MockDsl
class MockClient internal constructor(
	private val pluginMap: Map<MockClientPlugin<*, *>, Any>
) {
	
	@Suppress("UNCHECKED_CAST")
	internal fun <TConfig : Any, TPlugin : Any> getPlugin(
		plugin: MockClientPlugin<TConfig, TPlugin>
	): TPlugin = this.pluginMap[plugin] as? TPlugin ?: error("未找到 MockClient 插件")
}

@MockDsl
internal fun MockClient(
	block: MockClientConfig.() -> Unit
): MockClient {
	val config = MockClientConfigImpl().apply(block)
	return MockClient(config.pluginMap)
}

@MockDsl
internal sealed interface MockClientConfig {
	
	fun <TConfig : Any, TPlugin : Any> install(
		plugin: MockClientPlugin<TConfig, TPlugin>,
		block: (TConfig.() -> Unit)? = null
	)
}

private class MockClientConfigImpl : MockClientConfig {
	
	val pluginMap = mutableMapOf<MockClientPlugin<*, *>, Any>()
	
	override fun <TConfig : Any, TPlugin : Any> install(
		plugin: MockClientPlugin<TConfig, TPlugin>,
		block: (TConfig.() -> Unit)?
	) {
		this.pluginMap[plugin] = plugin.install { block?.invoke(this) }
	}
}