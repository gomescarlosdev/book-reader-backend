plugins {
    java
}

dependencies {
    api(project(":book-reader-data-access"))
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }