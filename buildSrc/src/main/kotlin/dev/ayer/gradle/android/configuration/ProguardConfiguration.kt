package dev.ayer.gradle.android.configuration

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.configuration.extensions.release

class ProguardConfiguration: GradleAndroidConfiguration  {
    override fun execute(baseAppModuleExtension: BaseAppModuleExtension) {
        val proguardFile = "proguard-android-optimize.txt"
        val androidSdkProguardFile = baseAppModuleExtension.getDefaultProguardFile(proguardFile)
        val moduleProguardFile = "proguard-rules.pro"

        baseAppModuleExtension.buildTypes.release.apply {
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(androidSdkProguardFile, moduleProguardFile)
        }
    }
}
