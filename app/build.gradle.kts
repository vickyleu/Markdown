plugins {
    alias(libs.plugins.android.application)
}

android {
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    namespace = "com.zzhoujay.markdowndemo"
    defaultConfig {
        applicationId = "com.zzhoujay.markdowndemo"
        minSdk = libs.versions.android.minSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
    lint {
        abortOnError = false

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
        implementation(projects.parser)
    }
}