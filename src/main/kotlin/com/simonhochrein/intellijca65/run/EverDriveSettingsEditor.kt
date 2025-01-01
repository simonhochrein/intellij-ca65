package com.simonhochrein.intellijca65.run

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel

class EverDriveSettingsEditor : SettingsEditor<EverDriveRunConfiguration>() {
    private val scriptPathField: TextFieldWithBrowseButton = TextFieldWithBrowseButton().apply {
        addBrowseFolderListener("Select Script Path", null, null, FileChooserDescriptorFactory.createSingleFileDescriptor())
    }
    private val myPanel: JPanel = FormBuilder.createFormBuilder().addLabeledComponent("Script file", scriptPathField).panel

    override fun resetEditorFrom(everDriveRunConfiguration: EverDriveRunConfiguration) {
        scriptPathField.text = everDriveRunConfiguration.scriptName ?: ""
    }

    override fun applyEditorTo(everDriveRunConfiguration: EverDriveRunConfiguration) {
        everDriveRunConfiguration.scriptName = scriptPathField.text
    }

    override fun createEditor() = myPanel
}
