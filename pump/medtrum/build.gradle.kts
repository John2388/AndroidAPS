plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-module-dependencies")
    id("test-module-dependencies")
}

apply(from = "${project.rootDir}/core/main/jacoco_global.gradle")

android {
    namespace = "info.nightscout.pump.medtrum"
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":database:entities"))
    implementation(project(":core:libraries"))
    implementation(project(":core:interfaces"))
    implementation(project(":core:main"))
    implementation(project(":core:ui"))
    implementation(project(":core:utils"))
    implementation(project(":core:validators"))
    implementation(project(":pump:pump-common"))

    testImplementation(project(":shared:tests"))
    testImplementation(project(":core:main"))

    kapt(Libs.Dagger.compiler)
    kapt(Libs.Dagger.androidProcessor)
}
