package com.huawei.test.toolbox

import com.jetbrains.toolbox.api.core.diagnostics.Logger
import com.jetbrains.toolbox.api.localization.LocalizableStringFactory
import com.jetbrains.toolbox.api.remoteDev.connection.RemoteToolsHelper
import com.jetbrains.toolbox.api.remoteDev.connection.ToolboxProxySettings
import com.jetbrains.toolbox.api.remoteDev.deploy.AgentDistributionProvider
import kotlinx.coroutines.CoroutineScope

class HwTestToolboxContext(
    val logger: Logger,
    val coroutines: CoroutineScope,
    val i18n: LocalizableStringFactory,
    var remoteToolsHelper: RemoteToolsHelper,
    val agentDistributionProvider: AgentDistributionProvider,
    val proxySettings: ToolboxProxySettings,
) {
}