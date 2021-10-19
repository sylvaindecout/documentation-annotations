val jvm_version: String by project
val junit_version: String by project

plugins {
    kotlin("jvm") version "1.5.31"
}

group = "fr.sdecout.annotations"
version = "0.1.0"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter", "junit-jupiter-api", junit_version)
    testImplementation("org.junit.jupiter", "junit-jupiter-params", junit_version)
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", junit_version)
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = jvm_version
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = jvm_version
        }
    }
    test {
        useJUnitPlatform()
    }
}
