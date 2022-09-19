package dev.ayer.gradle.android.configuration

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration

class ApplicationIdConfiguration: GradleAndroidConfiguration {
    override fun execute(baseAppModuleExtension: BaseAppModuleExtension) {
        baseAppModuleExtension.defaultConfig.applicationId = "com.ayer.gradle"
    }
}