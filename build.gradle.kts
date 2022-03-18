import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.google.cloud.tools.jib") version "3.0.0"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    kotlin("plugin.jpa") version "1.6.10"
}

java.sourceCompatibility = JavaVersion.VERSION_11

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.plugin.jpa")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("com.google.cloud.tools.jib")
    }

    buildscript {
        val springBootVersion = "2.1.0.RC1"

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
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    runtimeOnly("com.h2database:h2")
//    runtimeOnly("mysql:mysql-connector-java")
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