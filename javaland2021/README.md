# Kotlin multiplatformworkshop

Javaland 2021, Cummunity effort

Falk Sippach, Michal Harakal


## Set up the environment

* Current version of IntelliJ IDEA(2020.3.1) 
* or Android Studio 4.2 with KMM plugin

NOTE: Also check that you Android SDK has been installed.

## Getting Started mit IntelliJ IDEA

### Create project from template

1. Create new project from template via **File->New project ...**
2. From modules type select **Kotlin** and **Jetpack compose for Desktop (experimental)**

<h3 align="center">
  <img src="docs/images/new_project_wizard_01.png" alt="Project wizard, screen 1" />
</h3>

After succesfull import, you can comppile Android App or JVM Desktop App with gradle tasks:

**:desktop:run**
**:android:assembleDebug**

## Getting Started mit Android Studio 4.1.2

Requires **Kotlin 1.4.30+** and **macOS**

### Install KMM Plugin

<h3 align="center">
  <img src="docs/images/as_kmm_plugin.png" alt="Android studio, KMM Plugin" />
</h3>

### Create project from template

1. Create new project from template via **File->New project ...**
2. From Project Template select **KMM Application**

<h3 align="center">
  <img src="docs/images/as_new_project_wizard_01.png" alt="Project wizard, screen 1" />
</h3>

After succesfull import, you can comppile Android App or JVM Desktop App with gradle tasks:

**:android:assembleDebug**

For details follow offcial KMM documentation https://kotlinlang.org/docs/mobile/setup.html
