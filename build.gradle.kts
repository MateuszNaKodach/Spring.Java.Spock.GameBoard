plugins {
    groovy
    java
}

group = "com.github.nowakprojects"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:2.5.10")
    testImplementation("org.spockframework", "spock-core", "1.3-groovy-2.5")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    test {
        testLogging.events("passed", "skipped", "failed")
    }
}
