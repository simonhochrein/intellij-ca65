package com.simonhochrein.intellijca65.toolWindow

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.ide.util.treeView.AbstractTreeNodeCache
import com.intellij.ide.util.treeView.AbstractTreeStructure
import com.intellij.ide.util.treeView.NodeDescriptor
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.service
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.openapi.wm.impl.content.ToolWindowContentUi
import com.intellij.ui.ColoredTreeCellRenderer
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.dsl.builder.Align
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.tree.AsyncTreeModel
import com.intellij.ui.tree.StructureTreeModel
import com.intellij.ui.treeStructure.Tree
import com.simonhochrein.intellijca65.services.EverDriveService
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode

class EverDriveToolWindowFactory : ToolWindowFactory, DumbAware {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        toolWindow.contentManager.addContent(
            ContentFactory.getInstance()
                .createContent(EverDriveToolWindowContent(project, toolWindow).contentPanel, "EverDrive", false)
        )

        toolWindow.component.putClientProperty(ToolWindowContentUi.HIDE_ID_LABEL, "true")
    }
}

private class EverDriveToolWindowContent(val project: Project, toolWindow: ToolWindow) : Disposable {
    private lateinit var rtcTime: JLabel

    val contentPanel: JPanel
        get() = panel {
            row("Test") {
                button("Connect") {
                    println(project.service<EverDriveService>().getStatus())
                }
                button("Get RTC") {
                    rtcTime.text = project.service<EverDriveService>().getRTC().toString()
                }
                rtcTime = label("").component

            }
            row {
                scrollCell(treeView).align(Align.FILL)
            }
        }

    val treeView: Tree = Tree(AsyncTreeModel(StructureTreeModel(EverDriveStructure(), this), this)).apply {
        setCellRenderer(EverDriveCellRenderer())
    }

    inner class EverDriveCellRenderer : ColoredTreeCellRenderer() {
        override fun customizeCellRenderer(
            tree: JTree,
            value: Any?,
            selected: Boolean,
            expanded: Boolean,
            leaf: Boolean,
            row: Int,
            hasFocus: Boolean
        ) {
            val treeNode = value as DefaultMutableTreeNode
            val userObject = treeNode.userObject ?: return

            when (userObject) {
                is EverDriveStructure.RootNodeDescriptor -> {
                    icon = AllIcons.Nodes.Folder
                    append("EverDrive")
                }
                is EverDriveStructure.EverDriveFileSystemEntryDescriptor -> {
                    icon = if (userObject.entry.isDirectory) AllIcons.Nodes.Folder else AllIcons.FileTypes.Text
                    append(userObject.text)
                }
            }
        }

    }

    inner class EverDriveStructure : AbstractTreeStructure() {
        val myRoot = EverDriveFileSystemEntry("/", true)
        override fun getRootElement() = myRoot

        override fun getChildElements(element: Any): Array<Any> {
            return when (element) {
                myRoot -> arrayOf(
                    EverDriveFileSystemEntry("/test", true),
                    EverDriveFileSystemEntry("/test.txt", false)
                )
                else -> emptyArray()
            }
        }

        override fun getParentElement(element: Any) = when (element) {
            is EverDriveFileSystemEntry -> myRoot
            else -> null
        }

        override fun createDescriptor(element: Any, parentDescriptor: NodeDescriptor<*>?): NodeDescriptor<*> = when (element) {
            myRoot -> RootNodeDescriptor(project, null)
            is EverDriveFileSystemEntry -> EverDriveFileSystemEntryDescriptor(project, parentDescriptor, element)
            else -> throw UnsupportedOperationException()
        }

        override fun commit() = Unit
        override fun hasSomethingToCommit() = false

        inner class RootNodeDescriptor(project: Project, parentDescriptor: NodeDescriptor<*>?): EverDriveNodeDescriptor(project, parentDescriptor) {
            override fun update(): Boolean {
                return false
            }

            override fun getElement(): EverDriveFileSystemEntry {
                return myRoot
            }

        }

        inner class EverDriveFileSystemEntryDescriptor(project: Project, parentDescriptor: NodeDescriptor<*>?, val entry: EverDriveFileSystemEntry): EverDriveNodeDescriptor(project, parentDescriptor) {
            override fun update(): Boolean {
                return true
            }
            override fun getElement(): EverDriveFileSystemEntry {
                return entry
            }

            val text: String
                get() {
                    return entry.path.split('/').last()
                }
        }
    }

    override fun dispose() {

    }

}

data class EverDriveFileSystemEntry(val path: String, val isDirectory: Boolean)

abstract class EverDriveNodeDescriptor(project: Project, parentDescriptor: NodeDescriptor<*>?): NodeDescriptor<EverDriveFileSystemEntry>(project, parentDescriptor)