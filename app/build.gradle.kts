import dev.ayer.gradle.android.configuration.*
import dev.ayer.gradle.android.dependencies.AndroidXDependency
import dev.ayer.gradle.android.dependencies.ComposeDependency
import dev.ayer.gradle.android.dependencies.JUnitDependency
import dev.ayer.gradle.android.GradleConfigure
import dev.ayer.gradle.android.Versions

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val gradle = GradleConfigure(project)
val versions = Versions()

val applicationId = ApplicationIdConfiguration()
val applicationVersions = ApplicationVersionsConfiguration(
    versions.applicationBaseSdkVersions,
    versions.moduleVersions
)
val testInstrumentationRunner = TestInstrumentationRunnerConfiguration()
val javaVersion = JavaVersionConfiguration(versions.javaVersions)
val obfuscation = ObfuscationConfiguration()
val proguard = ProguardConfiguration()
val excludeMetadata = ExcludeMetadataConfiguration()

val compose = ComposeDependency(versions.composeVersions)
val jUnit = JUnitDependency(versions.jUnitVersion)
val androidX = AndroidXDependency(versions.androidXVersions).apply {
    core()
    activityCompose()
    lifecycleRuntime()
    extJUnit()
    espresso()
}

gradle.configure(
    applicationId,
    applicationVersions,
    testInstrumentationRunner,
    obfuscation,
    proguard,
    excludeMetadata
)

gradle.dependencies(
    compose,
    jUnit,
    androidX
)
