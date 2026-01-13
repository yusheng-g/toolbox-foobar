package com.huawei.test.toolbox

import com.huawei.test.toolbox.views.HwTestEnvironmentContentsView
import com.jetbrains.toolbox.api.remoteDev.AfterDisconnectHook
import com.jetbrains.toolbox.api.remoteDev.BeforeConnectionHook
import com.jetbrains.toolbox.api.remoteDev.EnvironmentVisibilityState
import com.jetbrains.toolbox.api.remoteDev.RemoteProviderEnvironment
import com.jetbrains.toolbox.api.remoteDev.environments.EnvironmentContentsView
import com.jetbrains.toolbox.api.remoteDev.states.EnvironmentDescription
import com.jetbrains.toolbox.api.remoteDev.states.RemoteEnvironmentState
import com.jetbrains.toolbox.api.remoteDev.states.StandardRemoteEnvironmentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HwTestRemoteProviderEnvironment(
    private val context: HwTestToolboxContext,
    id: String,
) : RemoteProviderEnvironment(id),BeforeConnectionHook, AfterDisconnectHook {
    override val nameFlow = MutableStateFlow(id)
    override val state: StateFlow<RemoteEnvironmentState>
        get() = MutableStateFlow<RemoteEnvironmentState>(StandardRemoteEnvironmentState.Active)
    override val description: StateFlow<EnvironmentDescription>
        get() = MutableStateFlow(EnvironmentDescription.General(context.i18n.pnotr("HwTestRemoteProviderEnvironment")))

    override suspend fun getContentsView(): EnvironmentContentsView {
        context.logger.info("getContentsView")
        return HwTestEnvironmentContentsView(context, id)
    }

    override fun setVisible(visibilityState: EnvironmentVisibilityState) {
        context.logger.info("setVisible")
    }

    override fun beforeConnection() {
        context.logger.info("beforeConnection")
    }

    override fun afterDisconnect(isManual: Boolean) {
        context.logger.info("afterDisconnect")
    }
}