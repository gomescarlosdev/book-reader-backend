plugins {
    java
}

dependencies {
    api(project(":book-reader-domain"))
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }