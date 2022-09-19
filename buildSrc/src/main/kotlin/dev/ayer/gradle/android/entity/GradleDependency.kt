package dev.ayer.gradle.android.entity

class GradleDependency(val dependencyNotation: String)

fun String.asGradleDependency() = GradleDependency(this)