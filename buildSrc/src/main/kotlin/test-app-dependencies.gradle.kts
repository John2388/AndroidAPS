import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("com.android.application")
    id("kotlin-android")
}

dependencies {
    testImplementation(Libs.Kotlin.test)
    testImplementation(Libs.JUnit.jupiter)
    testImplementation(Libs.JUnit.jupiterApi)
    testImplementation(Libs.json)
    testImplementation(Libs.Mockito.jupiter)
    testImplementation(Libs.Mockito.kotlin)
    testImplementation(Libs.jodaTime)
    testImplementation(Libs.Google.truth)
    testImplementation(Libs.jsonAssert)

    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
    androidTestImplementation(Libs.AndroidX.Test.extKtx)
    androidTestImplementation(Libs.AndroidX.Test.rules)
    //androidTestImplementation(Libs.AndroidX.Test.uiAutomator)
}

tasks.withType<Test> {
    // use to display stdout in travis
    testLogging {
        // set options for log level LIFECYCLE
        events = setOf(
            TestLogEvent.FAILED,
            TestLogEvent.STARTED,
            TestLogEvent.SKIPPED,
            TestLogEvent.STANDARD_OUT
        )
        exceptionFormat = TestExceptionFormat.FULL
        useJUnitPlatform()
    }
}

tasks.withType<Test>().configureEach {
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    forkEvery = 20
}

android {
    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }
}
