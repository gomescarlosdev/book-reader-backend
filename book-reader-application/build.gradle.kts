import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "2.7.13"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR9")
    }
}

dependencies {
    api(project(":book-reader-service"))
    api(project(":book-reader-data-access"))
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
        layerOrder = listOf(
            "dependencies",
            "spring-boot-loader",
            "book-reader-backend-dependencies",
            "application"
        )
    }
}
