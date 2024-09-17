plugins {
    id("java")
    id("org.springframework.boot") version "3.3.3"
    id("org.hibernate.orm") version "6.6.0.Final"
}

group = "com.busBooking"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:9.0.0")
    implementation("org.hibernate.orm:hibernate-core:6.6.0.Final")

}


tasks.test {
    useJUnitPlatform()
}