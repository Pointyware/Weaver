
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {

    jvmToolchain(21)
    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        binaries {
            executable {
                mainClass = "org.pointyware.weaver.example.MainKt"
            }
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core)
            }
        }
    }
}
