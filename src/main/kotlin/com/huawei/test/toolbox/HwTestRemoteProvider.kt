package com.huawei.test.toolbox

import com.jetbrains.toolbox.api.core.util.LoadableState
import com.jetbrains.toolbox.api.remoteDev.ProviderVisibilityState
import com.jetbrains.toolbox.api.remoteDev.RemoteProvider
import com.jetbrains.toolbox.api.remoteDev.RemoteProviderEnvironment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import java.net.URI

class HwTestRemoteProvider(
    private val context: HwTestToolboxContext
) : RemoteProvider(name = "FooBar") {

    private val _envs = MutableStateFlow<LoadableState<List<RemoteProviderEnvironment>>>(
        LoadableState.Value(listOf(
            HwTestRemoteProviderEnvironment(context, "devenv-1"),
            HwTestRemoteProviderEnvironment(context, "devenv-2"),
            HwTestRemoteProviderEnvironment(context, "devenv-3"),
        ))
    )

    override val canCreateNewEnvironments: Boolean
        get() = true
    override val isSingleEnvironment: Boolean
        get() = false
    override val environments: Flow<LoadableState<List<RemoteProviderEnvironment>>>
        get() = _envs

    override fun setVisible(visibilityState: ProviderVisibilityState) {
        context.logger.info("setVisible")
    }

    override suspend fun handleUri(uri: URI) {
        context.logger.info("handleUri")
    }

    override fun close() {
        context.logger.info("close")
    }
}