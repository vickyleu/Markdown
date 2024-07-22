@file:Suppress("UnstableApiUsage")
rootProject.name = "Markdown"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories.apply {
        removeAll(this)
    }
    dependencyResolutionManagement.repositories.apply {
        removeAll(this)
    }
    listOf(repositories, dependencyResolutionManagement.repositories).forEach {
        it.apply {
            mavenCentral {
                content {
                    excludeGroupByRegex("org.jetbrains.compose.*")
                    excludeGroupByRegex("org.jogamp.*")
                    excludeGroupByRegex("com.vickyleu.*")
                    excludeGroupByRegex("com.android.tools.*")
                    excludeGroupByRegex("androidx.compose.*")
                    excludeGroupByRegex("com.github.(?!johnrengelman|oshi).*")
                }
            }
            gradlePluginPortal {
                content {
                    excludeGroupByRegex("org.jogamp.*")
                    excludeGroupByRegex("com.vickyleu.*")
                    excludeGroupByRegex("org.jetbrains.compose.*")
                    excludeGroupByRegex("androidx.databinding.*")
                    // 避免无效请求,加快gradle 同步依赖的速度
                    excludeGroupByRegex("com.github.(?!johnrengelman).*")
                }
            }
            google {
                content {
                    excludeGroupByRegex("org.jetbrains.compose.*")
                    excludeGroupByRegex("org.jogamp.*")
                    includeGroupByRegex(".*google.*")
                    includeGroupByRegex(".*android.*")
                    excludeGroupByRegex("com.vickyleu.*")
                    excludeGroupByRegex("com.github.*")
                }
            }
        }
    }


}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        maven {
            setUrl("https://jitpack.io")
            content {
                excludeGroupByRegex("com.finogeeks.*")
                excludeGroupByRegex("org.jogamp.*")
                includeGroupByRegex("com.github.*")
                excludeGroupByRegex("org.jetbrains.compose.*")
            }
        }
        mavenCentral()
    }
}

include(":app")
include(":parser")