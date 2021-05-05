import io.qameta.allure.gradle.AllureExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.70"
    id("io.qameta.allure") version "2.8.1"
}

val junit5Version = "5.6.2"
val allureVersion = "2.13.6"

allure {
    autoconfigure = true
    aspectjweaver = true
    resultsDir = file("allure-results")
    reportDir = file("allure-report")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<AllureExtension> {
    autoconfigure = true
    aspectjweaver = true
    version = allureVersion
    clean = true
    useJUnit5 {
        version = allureVersion
    }
}

dependencies {

    implementation("org.seleniumhq.selenium:selenium-server:3.141.59")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")

    implementation("io.qameta.allure:allure-gradle:2.5")
    implementation( "org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")

    implementation("org.slf4j:slf4j-api:1.7.21")
    implementation("ch.qos.logback:logback-core:1.2.3")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("com.typesafe:config:1.3.3")

    implementation("io.cucumber:cucumber-java:4.0.0")
    implementation("io.cucumber:cucumber-testng:4.0.0")

    implementation("org.testng:testng:6.13.1")

    // http://www.unitils.org/tutorial-reflectionassert.html
    implementation("org.unitils:unitils-core:3.4.6")

    implementation("com.github.rholder:guava-retrying:2.0.0")

    implementation("org.seleniumhq.selenium:selenium-java:3.11.0")
    implementation("org.seleniumhq.selenium:selenium-support:3.11.0")

    implementation("ru.yandex.qatools.ashot:ashot:1.5.4")

    testImplementation(kotlin("stdlib-jdk8"))

    testImplementation("org.slf4j:slf4j-simple:1.7.30")

    implementation("org.jetbrains.kotlin:kotlin-test:1.2.60")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.2.60")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.22.5")
}


repositories {
    mavenCentral()
    jcenter()
}


tasks.withType(Test::class) {
    ignoreFailures = true
    useJUnitPlatform {

    }

    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")
    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")

//    testLogging {
//        events("passed", "skipped", "failed")
//    }
}