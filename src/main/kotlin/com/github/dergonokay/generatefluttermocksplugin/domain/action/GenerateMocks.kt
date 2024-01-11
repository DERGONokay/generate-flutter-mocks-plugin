package com.github.dergonokay.generatefluttermocksplugin.domain.action

import com.github.dergonokay.generatefluttermocksplugin.domain.configuration.AppSettingsState
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import java.util.concurrent.TimeUnit


class GenerateMocks {

    private val appSettings: AppSettingsState = AppSettingsState.instance

    operator fun invoke(actionData: ActionData): String {
        with(actionData) {
            val isDirectory = LocalFileSystem.getInstance().isDirectory(virtualFile)
            if (isDirectory) {
                println("Generating mocks for ${virtualFile.path}")
                val process = ProcessBuilder()
                    .directory(File(virtualFile.path))
                    .command(
                        "${appSettings.flutterPath}/bin/flutter",
                        "pub",
                        "run",
                        "build_runner",
                        "build",
                        "--delete-conflicting-outputs"
                    )
                    .redirectOutput(ProcessBuilder.Redirect.PIPE)
                    .redirectInput(ProcessBuilder.Redirect.PIPE)
                    .redirectError(ProcessBuilder.Redirect.PIPE)
                    .start()

                process.waitFor(500, TimeUnit.SECONDS)

                return """
                    Flutter path: ${appSettings.flutterPath}
                    Working directory: ${virtualFile.path}
                    Command: ${appSettings.flutterPath}/bin/flutter pub run build_runner build --delete-conflicting-outputs
                    Exit code: ${process.exitValue()}
                    Command output:
                    ${process.inputStream.bufferedReader().readText()}
                """.trimIndent()
            } else {
                println("Cannot generate mocks for a file!")
                return "Cannot generate mocks for a file ${virtualFile.path}, please select a folder"
            }
        }
    }

    data class ActionData(val virtualFile: VirtualFile)
}