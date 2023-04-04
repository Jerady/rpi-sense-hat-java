plugins {
    java
    application
}

group = "rpi.sensehat.hat"
version = "1.2"

repositories {
    mavenCentral()
}

application {
    mainClass.set("rpi.sensehat.example.Project")
}

dependencies {
    implementation("ch.qos.logback:logback-classic:${property("logback.version")}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${property("junit-jupiter.version")}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${property("junit-jupiter.version")}")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

