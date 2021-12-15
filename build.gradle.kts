plugins {
  kotlin("jvm") version "1.5.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

tasks.withType<Test> {
  useJUnitPlatform()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("com.sun.xml.bind:jaxb-impl:2.3.5")
  implementation("de.jollyday:jollyday:0.5.10")
  implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")

  testImplementation(kotlin("test"))
  testImplementation("io.kotest:kotest-runner-junit5:4.3.1")
}
