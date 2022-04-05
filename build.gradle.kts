import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.google.cloud.tools.jib") version "3.0.0"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spring.io/snapshot")
        url = uri("https://repo.spring.io/milestone")
    }
}

java.sourceCompatibility = JavaVersion.VERSION_11

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.plugin.jpa")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    buildscript {
        val springBootVersion = "2.6.5"

        repositories {
            mavenCentral()
            maven {
                url = uri("https://repo.spring.io/snapshot")
                url = uri("https://repo.spring.io/milestone")
            }
        }
        dependencies {
            classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        }
    }

    group = "info.log"
    version = "0.0.1-SNAPSHOT"

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.projectreactor:reactor-test")
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.1")

        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.springframework.cloud:spring-cloud-function-kotlin:3.2.2")
        implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka:3.2.2")
        testImplementation("org.springframework.cloud:spring-cloud-stream-test-support:3.2.2")

//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    runtimeOnly("com.h2database:h2")
//    runtimeOnly("mysql:mysql-connector-java")
    }
    if (!this.path.startsWith(":util")) {
        dependencies {
            implementation(project(":util"))
        }
    }

    if (this.path.startsWith(":microservices") && this.subprojects.isEmpty()) {
        apply {
            plugin("com.google.cloud.tools.jib")
        }
        repositories {
            maven {
                url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local/")
            }
        }

        dependencies {
            implementation("io.springfox:springfox-boot-starter:3.0.0")
        }

        jib {
            from {
                image = "openjdk:11.0.14.1-jdk-slim-buster"
            }
            to {
                image = "yhc94/msa-study-${project.name}"
                tags = setOf(project.version.toString(), "latest")
                auth {
                    username = "yhc94"
                    password = ""
                }
            }
        }
    }

    repositories {
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/snapshot")
            url = uri("https://repo.spring.io/milestone")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

if (project == rootProject) {
    tasks.register("jibAll") {
        for (subproject in subprojects) {
            if (System.getProperties()["jib.httpTimeout"] == null) {
                System.getProperties()["jib.httpTimeout"] = "120000"
            }
            val jibTask = subproject.tasks.firstOrNull { it.name == "jib" }
            if (jibTask != null) {
                dependsOn(jibTask)
            }
        }
        doLast {
        }
    }
}
