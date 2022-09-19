package dev.ayer.gradle.android.dependencies

import dev.ayer.gradle.android.aliases.GradleAndroidConfiguration
import dev.ayer.gradle.android.aliases.GradleDependencyConfiguration
import dev.ayer.gradle.android.androidTestImplementationAll
import dev.ayer.gradle.android.implementationAll
import dev.ayer.gradle.android.dependencies.versions.AndroidXVersions
import dev.ayer.gradle.android.entity.AndroidDependencyConfig

class AndroidXDependency(versions: AndroidXVersions): AndroidDependencyConfig {

    private val core by lazy { "androidx.core:core-ktx:${versions.core}" }
    private val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${versions.lifecycleRuntime}" }
    private val activityCompose by lazy { "androidx.activity:activity-compose:${versions.activityCompose}" }
    private val extJUnit by lazy { "androidx.test.ext:junit:${versions.extJunit}" }
    private val espresso by lazy { "androidx.test.espresso:espresso-core:${versions.espresso}" }

    private val implementationDependencies = ArrayList<String>()
    private val androidTestImplementationDependencies = ArrayList<String>()

    fun core() {
        implementationDependencies.addIfNotContains(core)
    }

    fun lifecycleRuntime() {
        implementationDependencies.addIfNotContains(lifecycleRuntime)
    }

    fun activityCompose() {
        implementationDependencies.addIfNotContains(activityCompose)
    }

    fun extJUnit() {
        androidTestImplementationDependencies.addIfNotContains(extJUnit)
    }

    fun espresso() {
        androidTestImplementationDependencies.addIfNotContains(espresso)
    }

    override val androidConfiguration: GradleAndroidConfiguration by lazy {
        GradleAndroidConfiguration {}
    }

    override val gradleDependencies: GradleDependencyConfiguration = {
        implementationAll(implementationDependencies)
        androidTestImplementationAll(androidTestImplementationDependencies)
    }

    private fun <T> ArrayList<T>.addIfNotContains(t: T) {
        if (!this.contains(t)) this.add(t)
    }
}