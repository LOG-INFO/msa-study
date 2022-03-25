dependencies {
    implementation(project(":api"))
    implementation(project(":event"))
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
}