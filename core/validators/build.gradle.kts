plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-module-dependencies")
    id("test-module-dependencies")
}

apply(from = "${project.rootDir}/core/main/jacoco_global.gradle")

android {
    namespace = "app.aaps.core.validators"
}


dependencies {
    implementation(project(":core:interfaces"))

    api(Libs.Dagger.android)
    api(Libs.Dagger.androidSupport)
    api(Libs.Google.Android.material)

    kapt(Libs.Dagger.compiler)
    kapt(Libs.Dagger.androidProcessor)
}