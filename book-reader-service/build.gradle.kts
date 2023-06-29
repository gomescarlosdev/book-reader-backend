plugins {
    java
}

dependencies {
    api(project(":book-reader-data-access"))
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }