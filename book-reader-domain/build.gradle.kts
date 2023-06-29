plugins {
    java
}

dependencies {
    api(project(":book-reader-commons"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.flywaydb:flyway-core")
    api("org.flywaydb:flyway-mysql")
    api("com.mysql:mysql-connector-j")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }