package com.simonhochrein.intellijca65.language.ca65

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.simonhochrein.intellijca65.language.ca65.psi.CA65Include

object CA65Util {
    fun findImports(project: Project): List<CA65Include> {
        val result = arrayListOf<CA65Include>()
        val virtualFiles = FileTypeIndex.getFiles(CA65FileType.INSTANCE, GlobalSearchScope.allScope(project))

        for (virtualFile in virtualFiles) {
            val ca65File = PsiManager.getInstance(project).findFile(virtualFile) ?: continue

            PsiTreeUtil.getChildrenOfType(ca65File, CA65Include::class.java)?.forEach {
                result.add(it)
            }
        }

        return result
    }
}