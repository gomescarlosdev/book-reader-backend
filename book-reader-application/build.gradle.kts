import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    api(project(":book-reader-service"))

    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-actuator")
    api("org.flywaydb:flyway-core")
}

springBoot {
    mainClass.set("br.com.bookreader.application.BookReaderApplication")
}

tasks.named<BootJar>("bootJar") {
    mainClass.set("br.com.bookreader.application.BookReaderApplication")
    isEnabled = true
    archiveFileName.set("book-reader-backend.jar")

    layered {
        isEnabled = true
        application {
            intoLayer("spring-boot-loader") {
                include("org/springframework/boot/loader/**")
            }
            intoLayer("application")
        }
        dependencies {
            intoLayer("book-reader-backend-dependencies") {
                include("br.com.bookreader*:*")
            }
            intoLayer("dependencies")
        }
        layerOrder.set(
            listOf(
                "dependencies",
                "spring-boot-loader",
                "book-reader-backend-dependencies",
                "application"
            )
        )
    }
}
