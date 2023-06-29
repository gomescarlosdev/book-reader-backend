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
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
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
}

dependencies {

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
	testImplementation("org.mockito:mockito-core:5.2.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}