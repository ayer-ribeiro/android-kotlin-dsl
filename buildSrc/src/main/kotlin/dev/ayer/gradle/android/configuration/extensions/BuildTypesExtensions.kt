package dev.ayer.gradle.android.configuration.extensions

import com.android.build.gradle.internal.dsl.BuildType
import org.gradle.api.NamedDomainObjectContainer

val NamedDomainObjectContainer<BuildType>.release: BuildType get() {
    return getByName("release")
}

val NamedDomainObjectContainer<BuildType>.debug: BuildType get() {
    return this.getByName("debug")
}
