package dev.ayer.gradle.android.configuration

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration

class ExcludeMetadataConfiguration : GradleAndroidConfiguration {
    override fun execute(baseAppModuleExtension: BaseAppModuleExtension) {
        baseAppModuleExtension.packagingOptions {
            resources {
                excludes += mutableSetOf("/META-INF/{AL2.0,LGPL2.1}")
            }
        }
    }
}