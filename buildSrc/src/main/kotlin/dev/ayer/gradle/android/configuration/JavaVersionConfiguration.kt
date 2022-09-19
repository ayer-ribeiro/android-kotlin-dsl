package dev.ayer.gradle.android.configuration

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.configuration.versions.JavaVersions
import org.gradle.api.Action
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

class JavaVersionConfiguration(
    private val versions: JavaVersions
): GradleAndroidConfiguration {

    override fun execute(baseAppModuleExtension: BaseAppModuleExtension) {
        baseAppModuleExtension.apply {
            compileOptions {
                sourceCompatibility = versions.java
                targetCompatibility = versions.java
            }
            kotlinOptions {
                jvmTarget = versions.java.toString()
            }
        }
    }

    fun BaseAppModuleExtension.kotlinOptions(configure: Action<KotlinJvmOptions>): Unit =
        (this as ExtensionAware).extensions.configure("kotlinOptions", configure)
}