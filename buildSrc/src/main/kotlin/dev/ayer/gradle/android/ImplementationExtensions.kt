package dev.ayer.gradle.android

import dev.ayer.gradle.android.entity.GradleDependencyData
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any):
        Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.implementationAll(dependencyNotation: List<Any>): List<Dependency?> =
    dependencyNotation.map { this.implementation(it) }

fun DependencyHandler.testImplementationAll(dependencyNotation: List<Any>): List<Dependency?> =
    dependencyNotation.map { this.testImplementation(it) }

fun DependencyHandler.androidTestImplementationAll(dependencyNotation: List<Any>): List<Dependency?> =
    dependencyNotation.map { this.androidTestImplementation(it) }

fun DependencyHandler.debugTestImplementationAll(dependencyNotation: List<Any>): List<Dependency?> =
    dependencyNotation.map { this.debugImplementation(it) }

fun DependencyHandler.resolveAllImplementations(gradleDependencyData: GradleDependencyData): List<Dependency?> {
    val implementation = gradleDependencyData.implementation.map { it.dependencyNotation }
    val testImplementation = gradleDependencyData.testImplementation.map { it.dependencyNotation }
    val androidTestImplementation = gradleDependencyData.androidTestImplementation.map { it.dependencyNotation }
    val debugImplementation = gradleDependencyData.debugImplementation.map { it.dependencyNotation }

    return this.implementationAll(implementation) +
    this.testImplementationAll(testImplementation) +
    this.androidTestImplementationAll(androidTestImplementation) +
    this.debugTestImplementationAll(debugImplementation)
}
