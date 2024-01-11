package com.github.dergonokay.generatefluttermocksplugin.presentation

import com.github.dergonokay.generatefluttermocksplugin.domain.action.GenerateMocks
import com.intellij.concurrency.currentThreadContext
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.JOptionPane
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenerateMockActionListener : AnAction() {

    val generateMocks = GenerateMocks()

    override fun actionPerformed(e: AnActionEvent) {
        val task: Task.Backgroundable = object : Task.Backgroundable(e.project, "Generate flutter mocks") {
            override fun run(indicator: ProgressIndicator) {
                val vf = e.dataContext.getData("virtualFile") as VirtualFile
                val actionData = GenerateMocks.ActionData(vf)
                val exitValue = generateMocks(actionData)
                JOptionPane.showMessageDialog(null, exitValue, "Generate Mocks", JOptionPane.INFORMATION_MESSAGE)
            }
        }
        ProgressManager.getInstance().run(task)
    }
}