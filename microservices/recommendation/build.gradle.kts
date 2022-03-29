dependencies {
    implementation(project(":api"))
    implementation(project(":event"))
    implementation(project(":mongodb-sequence"))
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
}