plugins {
    id("sent.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":sent-java-core"))
    implementation(project(":sent-java-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :sent-java-example:run` to run `Main`
    // Use `./gradlew :sent-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "dm.sent.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
