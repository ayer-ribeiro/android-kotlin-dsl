package dev.ayer.gradle.android.aliases

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Action
import org.gradle.kotlin.dsl.DependencyHandlerScope

typealias GradleAndroidConfiguration = Action<BaseAppModuleExtension>
typealias GradleDependencyConfiguration = DependencyHandlerScope.() -> Unit