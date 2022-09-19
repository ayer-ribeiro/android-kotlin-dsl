package dev.ayer.gradle.android.configuration

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.configuration.versions.ApplicationBaseSdkVersions
import dev.ayer.gradle.android.configuration.versions.ModuleVersions

class ApplicationVersionsConfiguration(
    private val versions: ApplicationBaseSdkVersions,
    private val moduleVersions: ModuleVersions
): GradleAndroidConfiguration {
    fun get() = GradleAndroidConfiguration {

    }

    override fun execute(baseAppModuleExtension: BaseAppModuleExtension) {
        baseAppModuleExtension.apply {
            compileSdk = versions.compileSdk
            defaultConfig {
                minSdk = versions.minSdk
                targetSdk = versions.targetSdk
                versionCode = moduleVersions.versionCode
                versionName = moduleVersions.versionName
            }
        }
    }
}