package cn.vividcode.multiplatform.ktor.client.api.config

/**
 * 项目：vividcode-multiplatform-ktor-client
 *
 * 作者：li-jia-wei
 *
 * 创建：2024/5/14 下午9:04
 *
 * 介绍：KtorConfig
 */
class KtorConfig internal constructor(
	var baseUrl: String = "http://localhost",
	var token: (() -> String)? = null
) {
	
	/**
	 * 检查
	 */
	fun check() {
		check(this.baseUrl.isNotEmpty()) { "baseUrl 没有配置" }
		checkNotNull(this.token) { "token 没有配置" }
	}
}