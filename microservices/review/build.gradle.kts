dependencies {
    implementation(project(":api"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("mysql:mysql-connector-java")
    testImplementation("com.h2database:h2")
}