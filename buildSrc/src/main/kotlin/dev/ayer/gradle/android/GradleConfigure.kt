package dev.ayer.gradle.android

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.aliases.GradleDependencyConfiguration
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.dependencies
import dev.ayer.gradle.android.entity.AndroidDependencyConfig


class GradleConfigure(private val project: Project) {

    fun configure(vararg configures: GradleAndroidConfiguration) {
        configures.forEach { configure(it) }
    }

    fun configure(configure: GradleAndroidConfiguration) {
        project.android(configure)
    }

    fun dependencies(dependency: AndroidDependencyConfig) {
        configure(dependency.androidConfiguration)
        dependencies(dependency.gradleDependencies)
    }

    fun dependencies(vararg dependencies: AndroidDependencyConfig) {
        dependencies.forEach { dependencies(it) }
    }

    fun dependencies(dependency: GradleDependencyConfiguration) {
        project.dependencies(dependency)
    }

    fun dependencies(vararg dependencies: GradleDependencyConfiguration) {
        dependencies.forEach { dependencies(it) }
    }

    private fun Project.android(configure: Action<BaseAppModuleExtension>): Unit =
        (this as ExtensionAware).extensions.configure("android", configure)
}
