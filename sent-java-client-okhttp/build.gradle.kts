plugins {
    id("sent.kotlin")
    id("sent.publish")
}

dependencies {
    api(project(":sent-java-core"))

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
}
