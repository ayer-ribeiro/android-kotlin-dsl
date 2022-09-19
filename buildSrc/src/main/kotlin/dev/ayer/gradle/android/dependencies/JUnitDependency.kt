package dev.ayer.gradle.android.dependencies

import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.aliases.GradleDependencyConfiguration
import dev.ayer.gradle.android.dependencies.versions.JUnitVersion
import dev.ayer.gradle.android.entity.AndroidDependencyConfig
import dev.ayer.gradle.android.entity.asGradleDependency
import dev.ayer.gradle.android.testImplementation

class JUnitDependency(version: JUnitVersion): AndroidDependencyConfig {
    private val jUnit by lazy { "junit:junit:${version.jUnit}" }

    override val androidConfiguration: GradleAndroidConfiguration by lazy {
        GradleAndroidConfiguration {}
    }

    override val gradleDependencies: GradleDependencyConfiguration = {
        testImplementation(jUnit)
    }
}
