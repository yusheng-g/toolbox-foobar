package com.huawei.test.toolbox

import com.jetbrains.toolbox.api.core.ServiceLocator
import com.jetbrains.toolbox.api.core.diagnostics.Logger
import com.jetbrains.toolbox.api.core.getService
import com.jetbrains.toolbox.api.localization.LocalizableStringFactory
import com.jetbrains.toolbox.api.remoteDev.RemoteDevExtension
import com.jetbrains.toolbox.api.remoteDev.RemoteProvider
import com.jetbrains.toolbox.api.remoteDev.connection.RemoteToolsHelper
import com.jetbrains.toolbox.api.remoteDev.connection.ToolboxProxySettings
import com.jetbrains.toolbox.api.remoteDev.deploy.AgentDistributionProvider
import kotlinx.coroutines.CoroutineScope

class HwTestToolboxExtension : RemoteDevExtension{
    override fun createRemoteProviderPluginInstance(serviceLocator: ServiceLocator): RemoteProvider {
        return HwTestRemoteProvider(HwTestToolboxContext(
            serviceLocator.getService(Logger::class.java),
            serviceLocator.getService<CoroutineScope>(),
            serviceLocator.getService<LocalizableStringFactory>(),
            serviceLocator.getService<RemoteToolsHelper>(),
            serviceLocator.getService<AgentDistributionProvider>(),
            serviceLocator.getService<ToolboxProxySettings>(),
        ));
    }
}