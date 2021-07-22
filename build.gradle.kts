plugins {
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.liquibase.gradle") version "2.0.3"
    java
}

group = "com.pwr.AngularSpring"
version = "0.0.1-SNAPSHOT"
description = "Store"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

liquibase {
    activities {
        register("main") {
            val dbRDBMS: String by project.extra.properties
            val dbHost: String by project.extra.properties
            val dbPort: String by project.extra.properties
            val dbDatabase: String by project.extra.properties
            val dbUsername: String by project.extra.properties
            val dbPassword: String by project.extra.properties

            arguments = mapOf(
                "changeLogFile" to "src/main/db/db.yaml",
                "url" to "jdbc:${dbRDBMS}://${dbHost}:${dbPort}/${dbDatabase}",
                "username" to dbUsername,
                "password" to dbPassword
            )
        }
    }
    runList = "main"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("org.springframework.security:spring-security-test")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    liquibaseRuntime("org.liquibase:liquibase-core")
    liquibaseRuntime("org.postgresql:postgresql")
    liquibaseRuntime("org.yaml:snakeyaml")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<ProcessResources> {
    include("*.yml", "*.yaml", "*.properties")
    expand(project.properties)
}
