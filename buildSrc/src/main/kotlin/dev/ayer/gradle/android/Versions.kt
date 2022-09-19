package dev.ayer.gradle.android

import dev.ayer.gradle.android.dependencies.versions.ComposeVersions
import dev.ayer.gradle.android.dependencies.versions.JUnitVersion
import dev.ayer.gradle.android.configuration.versions.ApplicationBaseSdkVersions
import dev.ayer.gradle.android.configuration.versions.JavaVersions
import dev.ayer.gradle.android.configuration.versions.ModuleVersions
import dev.ayer.gradle.android.dependencies.versions.AndroidXVersions
import org.gradle.api.JavaVersion

class Versions {
    val applicationBaseSdkVersions by lazy { object : ApplicationBaseSdkVersions {
        override val compileSdk = 33
        override val minSdk = 21
        override val targetSdk = 33
    }}

    val moduleVersions by lazy { object : ModuleVersions {
        override val versionCode = 1
        override val versionName = "1.0"
    }}

    val javaVersions by lazy { object : JavaVersions {
        override val java = JavaVersion.VERSION_1_8
    }}

    val composeVersions by lazy { object : ComposeVersions {
        override val compose = "1.3.0-beta01"
        override val composeMaterial3 = "1.0.0-beta02"
    }}

    val androidXVersions by lazy { object: AndroidXVersions {
        override val core = "1.9.0"
        override val lifecycleRuntime = "2.5.1"
        override val activityCompose = "1.5.1"
        override val extJunit = "1.1.3"
        override val espresso = "3.4.0"
    }}

    val jUnitVersion by lazy { object : JUnitVersion {
        override val jUnit = "4.13.2"
    }}
}
