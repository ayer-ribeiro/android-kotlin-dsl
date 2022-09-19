package dev.ayer.gradle.android.configuration

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.configuration.extensions.release

class ObfuscationConfiguration: GradleAndroidConfiguration {
    override fun execute(baseAppModuleExtension: BaseAppModuleExtension) {
        baseAppModuleExtension.buildTypes.release.apply {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
}
