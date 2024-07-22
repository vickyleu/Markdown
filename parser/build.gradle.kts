plugins {
    alias(libs.plugins.android.library)
}

android {
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    namespace = "com.zzhoujay.markdown"
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    sourceSets {
        getByName("main") {
            this.java {
                srcDirs("src/main/java","src/main/kotlin")
            }
        }
    }
    publishing {
        singleVariant("release"){
            withSourcesJar()
            withJavadocJar()
        }
    }
    lint {
        abortOnError = false
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    dependencies {

    }
}