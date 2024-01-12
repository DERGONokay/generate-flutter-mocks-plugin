# Generate flutter mocks

![Build](https://github.com/DERGONokay/generate-flutter-mocks-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/com.github.dergonokay.generatefluttermocksplugin.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/com.github.dergonokay.generatefluttermocksplugin.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

<!-- Plugin description -->
This plugin generates mocks for flutter projects. It generates mocks for classes that are annotated with `@GenerateMocks`/`@GenerateNiceMocks` from the [mockito](https://pub.dev/packages/mockito) package.

# How to use

1. Set the flutter SDK path in the plugin settings. Go to `Settings/Preferences` > `Tools` > `Generate Flutter Mocks` and set the path to your flutter SDK.
2. Right click on a class and select `Generate Flutter Mocks` from the context menu (cmd + shift + G).
<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "generate-flutter-mocks-plugin"</kbd> >
  <kbd>Install</kbd>
  
- Manually:

  Download the [latest release](https://github.com/DERGONokay/generate-flutter-mocks-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>tools</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
