package com.simonhochrein.intellijca65.run

import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.NotNullLazyValue

class EverDriveRunConfigurationType : ConfigurationTypeBase(ID, "EverDrive", "EverDrive N8 Pro run configuration type", NotNullLazyValue.createValue { AllIcons.Nodes.Console }) {
    companion object {
        const val ID = "EverDriveRunConfiguration"
    }

    init {
        addFactory(EverDriveConfigurationFactory(this))
    }

}
