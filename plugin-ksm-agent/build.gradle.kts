plugins {
  kotlin("jvm")
  kotlin("plugin.serialization") version "2.0.20"
  id("io.github.rodm.teamcity-agent") version "1.5.5"
}

teamcity {
  version = rootProject.extra["teamcityVersion"] as String
  agent {
    descriptor = project.file("teamcity-plugin.xml")
  }
}

repositories {
  mavenCentral()
  maven(url = "https://download.jetbrains.com/teamcity-repository")
}

dependencies {
  implementation(project(":plugin-ksm-common"))

  implementation("com.keepersecurity.secrets-manager:core:16.6.5")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
  testImplementation("com.squareup.okhttp3:okhttp:4.12.0")
  testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")

  implementation("com.squareup.moshi:moshi:1.15.1")
  compileOnly("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")

  testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
  testImplementation("org.mockito:mockito-inline:5.2.0")
  testImplementation("org.assertj:assertj-core:3.26.3")
  testImplementation("org.junit.jupiter:junit-jupiter:5.11.1")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.1")
}
