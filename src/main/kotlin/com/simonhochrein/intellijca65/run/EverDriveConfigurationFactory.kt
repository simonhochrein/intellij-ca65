package com.simonhochrein.intellijca65.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project

class EverDriveConfigurationFactory(configurationType: ConfigurationType) : ConfigurationFactory(configurationType) {
    override fun getId(): String {
        return EverDriveRunConfigurationType.ID
    }
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return EverDriveRunConfiguration(project, this, "EverDrive")
    }

    override fun getOptionsClass(): Class<out BaseState> {
        return EverDriveRunConfigurationOptions::class.java
    }

}
