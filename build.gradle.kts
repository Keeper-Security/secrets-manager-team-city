plugins {
  java
  kotlin("jvm") version "1.9.24" apply false
}

extra["teamcityVersion"] = findProperty("teamcityVersion") ?: "2018.1"
extra["buildVersion"] = findProperty("buildVersion") ?: "1.0.1"
extra["group"] = "teamcity-ksm-plugin"
extra["version"] = extra["buildVersion"]

group = extra["group"]!!
version = extra["version"]!!

repositories {
  mavenCentral()
  mavenLocal()
  google()
}

allprojects {
    version = rootProject.version
}

subprojects {
    apply(plugin="kotlin")
    apply(plugin="java")

    tasks.withType<JavaCompile>().configureEach {
        javaCompiler.set(javaToolchains.compilerFor {
            languageVersion.set(JavaLanguageVersion.of(8))
        })
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}
