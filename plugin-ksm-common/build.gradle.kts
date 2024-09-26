plugins {
  kotlin("jvm")
}

repositories {
    mavenCentral()
    maven(url = "https://download.jetbrains.com/teamcity-repository")
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
  implementation("com.keepersecurity.secrets-manager:core:16.6.5")

  compileOnly("org.jetbrains.teamcity:common-api:${rootProject.extra["teamcityVersion"]}")

  testImplementation("org.jetbrains.teamcity:server-api:${rootProject.extra["teamcityVersion"]}")
  testImplementation("org.assertj:assertj-core:3.26.3")
  testImplementation("org.junit.jupiter:junit-jupiter:5.11.1")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.1")
}
