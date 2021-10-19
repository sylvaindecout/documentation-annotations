val jvm_version: String by project
val junit_version: String by project

plugins {
    kotlin("jvm") version "1.5.31"
    `maven-publish`
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
    jar {
        manifest {
            attributes(mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            ))
        }
    }
}

java {
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/sylvaindecout/documentation-annotations")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

