
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.kotlinxKover)
    alias(libs.plugins.publishMultiplatform)
}

kotlin {

    jvmToolchain(21)
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.koin.coroutines)

                implementation(libs.kotlinx.html.jvm)

                implementation(libs.kotlinx.serialization.json)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
                implementation(libs.kotlinx.coroutinesTest)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates("org.pointyware", "weaver-core", libs.versions.project.get())

    pom {
        name = "Weaver Website Builder"
        description = "Weaver Core Module"
        inceptionYear = "2024"
        url = "http://github.com/Pointyware/Weaver"
        licenses {
            license {
                name = "GNU General Public License, 3.0"
                url = "https://www.gnu.org/licenses/gpl-3.0.txt"
            }
        }
        developers {
            developer {
                id = "TSampley"
                name = "Taush Sampley"
                email = "tsampley@pointyware.org"
            }
        }
        scm {
            val repo = "github.com/Pointyware/Weaver"
            connection = "scm:git:git://$repo.git"
            developerConnection = "scm:git:ssh://$repo.git"
            url = "http://$repo/"
        }
    }
}
