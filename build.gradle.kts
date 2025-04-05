plugins {
    id("java")
}

group = "by.yurhilevich"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("ch.qos.logback:logback-classic:1.5.18")
    implementation("ch.qos.logback:logback-core:1.5.18")

    annotationProcessor("org.projectlombok:lombok:1.18.34")
    compileOnly("org.projectlombok:lombok:1.18.34")
}

tasks.test {
    useJUnitPlatform()
}