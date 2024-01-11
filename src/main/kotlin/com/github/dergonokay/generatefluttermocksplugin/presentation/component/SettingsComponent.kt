package com.github.dergonokay.generatefluttermocksplugin.presentation.component

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Supports creating and managing a [JPanel] for the Settings Dialog.
 */
class AppSettingsComponent {
    val panel: JPanel
    private val flutterSdkPathField = JBTextField()

    init {
        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Flutter SDK path: "), flutterSdkPathField, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    val preferredFocusedComponent: JComponent
        get() = flutterSdkPathField

    var flutterSdkPath: String?
        get() = flutterSdkPathField.getText()
        set(newText) {
            flutterSdkPathField.setText(newText)
        }
}