plugins {
    id("sent-dm.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sent-dm-java-core"))
    implementation(project(":sent-dm-java-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :sent-dm-java-example:run` to run `Main`
    // Use `./gradlew :sent-dm-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.sent_dm.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
