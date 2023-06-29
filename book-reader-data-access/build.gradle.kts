plugins {
    java
}

dependencies {
    runtimeOnly("com.mysql:mysql-connector-j")
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }