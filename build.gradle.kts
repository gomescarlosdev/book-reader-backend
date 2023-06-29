buildscript {
	repositories {
		mavenCentral()
	}
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

plugins {
	java
	id("org.springframework.boot") version "2.7.13"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

allprojects {
	repositories {
		mavenCentral()
	}

	group = "br.com.bookreader"
	version = "0.0.1"

	tasks.withType<Test> {
		useJUnitPlatform()

		if (!project.hasProperty("integrated-test")) {
			exclude("**/*IT.class")
		}

		testLogging {
			events("passed", "skipped", "failed")
			showStackTraces = true
			exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
		}
	}
}

subprojects {
	apply {
		plugin("java-library")
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("org.flywaydb:flyway-core")
		implementation("org.flywaydb:flyway-mysql")
		implementation("com.mysql:mysql-connector-j")
		implementation("org.modelmapper:modelmapper:2.4.4")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
		testImplementation("org.mockito:mockito-core:5.2.0")
		testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

		compileOnly("org.projectlombok:lombok:1.18.22")
		annotationProcessor ("org.projectlombok:lombok:1.18.22")
	}
}

