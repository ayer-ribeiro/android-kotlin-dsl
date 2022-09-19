package dev.ayer.gradle.android.dependencies

import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.aliases.GradleDependencyConfiguration
import dev.ayer.gradle.android.dependencies.versions.ComposeVersions
import dev.ayer.gradle.android.resolveAllImplementations
import dev.ayer.gradle.android.entity.GradleDependencyData
import dev.ayer.gradle.android.entity.GradleDependency
import dev.ayer.gradle.android.entity.AndroidDependencyConfig
import dev.ayer.gradle.android.entity.asGradleDependency

class ComposeDependency(
    private val versions: ComposeVersions,
): AndroidDependencyConfig {

    private val composeUi by lazy { "androidx.compose.ui:ui:${versions.compose}" }
    private val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview:${versions.compose}" }
    private val composeMaterial by lazy { "androidx.compose.material3:material3:${versions.composeMaterial3}" }
    private val composeUiTestJunit by lazy { "androidx.compose.ui:ui-test-junit4:${versions.compose}" }
    private val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${versions.compose}" }
    private val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${versions.compose}" }

    private val composeImplementationDependencies: List<GradleDependency> by lazy { listOf(
        composeUi.asGradleDependency(),
        composePreview.asGradleDependency(),
        composeMaterial.asGradleDependency()
    )}

    private val composeAndroidTestImplementationDependencies: List<GradleDependency> by lazy {
        listOf(composeUiTestJunit.asGradleDependency())
    }

    private val composeDebugImplementationDependencies: List<GradleDependency> by lazy {
        listOf(
            composeUiTooling.asGradleDependency(),
            composeUiTestManifest.asGradleDependency()
        )
    }

    private val gradleDependencyData: GradleDependencyData
        get() = GradleDependencyData(
            implementation = composeImplementationDependencies,
            testImplementation = emptyList(),
            androidTestImplementation = composeAndroidTestImplementationDependencies,
            debugImplementation = composeDebugImplementationDependencies,
        )

    override val androidConfiguration: GradleAndroidConfiguration by lazy {
        GradleAndroidConfiguration {
            buildFeatures.compose = true
            composeOptions.kotlinCompilerExtensionVersion = versions.compose
        }
    }

    override val gradleDependencies: GradleDependencyConfiguration = {
        resolveAllImplementations(gradleDependencyData)
    }
}
