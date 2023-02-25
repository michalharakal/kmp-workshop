plugins {
    id("ru.vyarus.mkdocs") version "2.3.0"
}

python {
    minPythonVersion = "3.8"
    scope = ru.vyarus.gradle.plugin.python.PythonExtension.Scope.USER
}