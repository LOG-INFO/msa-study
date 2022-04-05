dependencies {
    implementation(project(":api"))
    implementation(project(":event"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java")
    testImplementation("com.h2database:h2")
}