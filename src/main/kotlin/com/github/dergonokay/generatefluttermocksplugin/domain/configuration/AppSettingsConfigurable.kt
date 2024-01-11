package com.github.dergonokay.generatefluttermocksplugin.domain.configuration

import com.github.dergonokay.generatefluttermocksplugin.presentation.component.AppSettingsComponent
import com.intellij.openapi.options.Configurable

import javax.swing.JComponent

import org.jetbrains.annotations.Nls


/**
 * Provides controller functionality for application settings.
 */
internal class AppSettingsConfigurable : Configurable {
    private var mySettingsComponent: AppSettingsComponent? = null

    override fun createComponent(): JComponent {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent!!.panel
    }

    override fun apply() {
        val settings: AppSettingsState = AppSettingsState.instance
        settings.flutterPath = mySettingsComponent?.flutterSdkPath ?: ""
    }

    override fun reset() {
        val settings: AppSettingsState = AppSettingsState.instance
        mySettingsComponent?.flutterSdkPath =  settings.flutterPath
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }

    override fun isModified(): Boolean {
        val settings: AppSettingsState = AppSettingsState.instance
        return !mySettingsComponent?.flutterSdkPath.equals(settings.flutterPath)
    }

    override fun getDisplayName(): String {
        return "Generate Flutter Mocks"
    }
}