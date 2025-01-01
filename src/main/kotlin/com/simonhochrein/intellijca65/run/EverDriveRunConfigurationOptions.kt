package com.simonhochrein.intellijca65.run

import com.intellij.execution.configurations.RunConfigurationOptions

class EverDriveRunConfigurationOptions: RunConfigurationOptions() {
    private val myScriptName = string("").provideDelegate(this, "scriptName")

    var scriptName: String?
        get() = myScriptName.getValue(this)
        set(value) = myScriptName.setValue(this, value)
}
