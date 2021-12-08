plugins {
    kotlin("jvm") version "1.6.0"
    id("idea")
}

allprojects {
    group = "com.tibtof.kotlin-driven-testing"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    tasks {
        withType<Test> {
            useJUnitPlatform()
        }
    }
}
