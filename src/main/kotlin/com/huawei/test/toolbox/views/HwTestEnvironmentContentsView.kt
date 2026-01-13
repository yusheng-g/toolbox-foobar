package com.huawei.test.toolbox.views

import com.huawei.test.toolbox.HwTestToolboxContext
import com.jetbrains.toolbox.api.remoteDev.deploy.DeploymentSettings
import com.jetbrains.toolbox.api.remoteDev.environments.SshEnvironmentContentsView
import com.jetbrains.toolbox.api.remoteDev.ssh.SshConnectionInfo

class HwTestEnvironmentContentsView(
    private val context: HwTestToolboxContext,
    private val id: String,
): SshEnvironmentContentsView {
    override suspend fun getConnectionInfo(): SshConnectionInfo {
        context.logger.info("getConnectionInfo")
        return HwTestSshConnectionInfo(context, id)
    }

    override val deploymentSettings: DeploymentSettings
        get() = DeploymentSettings(null, true, null)
}

private class HwTestSshConnectionInfo(
    private val context: HwTestToolboxContext,
    private val id: String,
) : SshConnectionInfo {

    override val host: String = "127.0.0.1"

    override val port: Int = 22

    override val userName: String = "root"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HwTestSshConnectionInfo

        if (port != other.port) return false
        if (host != other.host) return false

        return true
    }

    override fun hashCode(): Int {
        var result = port
        result = 31 * result + host.hashCode()
        return result
    }
}