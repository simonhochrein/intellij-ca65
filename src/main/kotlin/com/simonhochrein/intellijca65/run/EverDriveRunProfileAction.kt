package com.simonhochrein.intellijca65.run

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.simonhochrein.intellijca65.services.EverDriveService

class EverDriveRunProfileAction : AnAction("Upload to EverDrive", null, AllIcons.Actions.Upload) {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        ProgressManager.getInstance().run(object: Task.Backgroundable(project, "Upload to EverDrive") {
            override fun run(indicator: ProgressIndicator) {
                indicator.isIndeterminate = false
                indicator.fraction = 0.2
                indicator.text = "Upload to EverDrive"
                println(project.service<EverDriveService>().getStatus())
                indicator.fraction = 1.0
            }
        })
    }
}