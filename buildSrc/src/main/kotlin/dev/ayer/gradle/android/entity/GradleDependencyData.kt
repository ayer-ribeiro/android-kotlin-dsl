package dev.ayer.gradle.android.entity

class GradleDependencyData(
    val implementation: List<GradleDependency>,
    val testImplementation: List<GradleDependency>,
    val androidTestImplementation: List<GradleDependency>,
    val debugImplementation: List<GradleDependency>,
)