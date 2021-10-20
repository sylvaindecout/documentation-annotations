val jvm_version: String by project

plugins {
    kotlin("jvm") version "1.5.31"
    `maven-publish`
}

group = "fr.sdecout.annotations"
version = "0.1.3"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = jvm_version
        }
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
            pom {
                name.set(project.name)
                description.set("This library defines annotations that can be used to document code, with the goal to make concepts explicit and to provide a quick way to find out more about them.")
                url.set("https://github.com/sylvaindecout/documentation-annotations")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("sylvaindecout")
                        name.set("Sylvain DECOUT")
                    }
                }
                issueManagement {
                    system.set("GitHub Issues")
                    url.set("https://github.com/sylvaindecout/documentation-annotations/issues")
                }
                ciManagement {
                    system.set("GitHub Actions")
                    url.set("https://github.com/sylvaindecout/documentation-annotations/actions")
                }
                scm {
                    connection.set("scm:git:git@github.com:sylvaindecout/documentation-annotations.git")
                    developerConnection.set("scm:git:git@github.com:sylvaindecout/documentation-annotations.git")
                    url.set("https://github.com/sylvaindecout/documentation-annotations")
                }
            }
        }
    }
}

