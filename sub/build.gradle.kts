plugins {
    id("java")
    id("org.springframework.boot") version ("3.3.3")
    id("io.spring.dependency-management") version ("1.1.6")
}

group = "by.korona"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    compileOnly("org.projectlombok:lombok:1.18.34")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("ch.qos.logback:logback-classic:1.5.18")
    implementation("ch.qos.logback:logback-core:1.5.18")

}
