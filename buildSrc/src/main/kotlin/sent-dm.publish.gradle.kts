import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal")) {
          maven {
              name = "LocalFileSystem"
              url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("Sent DM API - v3")
        description.set("The Sent DM API enables programmatic SMS and WhatsApp messaging with contact\nmanagement, template-based messaging, compliance (10DLC brand/campaign\nregistration), and webhook delivery tracking.\n\n## Authentication\n\nAll requests require the `x-api-key` header with your API key (e.g.\n`sk_live_...` for production, `sk_test_...` for sandbox). Your account is\nidentified automatically from the key.\n\n## Idempotency\n\nPOST, PUT, and PATCH requests accept an optional `Idempotency-Key` header. When\nprovided, the API guarantees at-most-once execution: duplicate requests with the\nsame key return the original response. Keys are scoped per customer and expire\nafter 24 hours.\n\n## Test Mode\n\nAll mutation endpoints (POST, PUT, DELETE) accept an optional `test_mode` field\nin the request body. When set to `true`, the API validates the request and\nreturns a realistic fake response **without executing any side effects** — no\ndatabase writes, no messages sent, no external API calls.\n\nTest mode is useful for:\n\n- **Integration testing** — verify your request payloads and response parsing\n  without affecting real data\n- **CI/CD pipelines** — run end-to-end tests against the live API without\n  consuming resources\n- **Client development** — build and test your integration before going live\n\n```json\n{\n  \"test_mode\": true,\n  \"phone_number\": \"+1234567890\"\n}\n```\n\nTest mode responses include the `X-Test-Mode: true` header and return the same\nschema as real responses with sample data. Authentication and validation still\nrun normally — only the service-layer execution is skipped.\n\n## Rate Limiting\n\nAPI requests are rate-limited per customer. Standard endpoints allow **200\nrequests/minute**; sensitive endpoints (e.g. secret rotation) allow **10\nrequests/minute**. When limits are exceeded, the API returns\n`429 Too Many Requests`.\n\nRate limit headers on `429` responses: | Header | Description |\n|--------|-------------| | `Retry-After` | Seconds until you can retry | |\n`X-RateLimit-Limit` | Maximum requests allowed in the window | |\n`X-RateLimit-Remaining` | Requests remaining (always `0` on 429) | |\n`X-RateLimit-Reset` | Unix timestamp when the window resets |\n\n## Common Response Headers\n\nAll responses include these headers: | Header | Description |\n|--------|-------------| | `X-Request-Id` | Unique request identifier for\nsupport and debugging | | `X-Response-Time` | Server processing time (e.g.\n`12ms`) | | `X-API-Version` | API version (always `v3`) |\n\nIdempotent replay responses also include: | Header | Description |\n|--------|-------------| | `Idempotent-Replayed` | `true` if this is a cached\nreplay | | `X-Original-Request-Id` | Request ID of the original request |\n\n## Errors\n\nAll errors follow a consistent JSON envelope:\n\n```json\n{\n  \"success\": false,\n  \"error\": {\n    \"code\": \"RESOURCE_001\",\n    \"message\": \"Contact not found\",\n    \"doc_url\": \"https://docs.sent.dm/errors/RESOURCE_001\"\n  },\n  \"meta\": { \"request_id\": \"req_...\", \"timestamp\": \"...\", \"version\": \"v3\" }\n}\n```\n\n### Error Code Reference\n\n| Code               | Description                                    |\n| ------------------ | ---------------------------------------------- |\n| **Authentication** |                                                |\n| `AUTH_001`         | User is not authenticated                      |\n| `AUTH_002`         | Invalid or expired API key                     |\n| `AUTH_004`         | Insufficient permissions for this operation    |\n| **Validation**     |                                                |\n| `VALIDATION_001`   | Request validation failed                      |\n| `VALIDATION_002`   | Invalid phone number format                    |\n| `VALIDATION_003`   | Invalid GUID format                            |\n| `VALIDATION_004`   | Required field is missing                      |\n| `VALIDATION_005`   | Field value out of valid range                 |\n| `VALIDATION_006`   | Invalid enum value                             |\n| `VALIDATION_007`   | Invalid Idempotency-Key format                 |\n| **Resource**       |                                                |\n| `RESOURCE_001`     | Contact not found                              |\n| `RESOURCE_002`     | Template not found                             |\n| `RESOURCE_003`     | Message not found                              |\n| `RESOURCE_004`     | Customer not found                             |\n| `RESOURCE_005`     | Organization not found                         |\n| `RESOURCE_006`     | User not found                                 |\n| `RESOURCE_007`     | Resource already exists (duplicate)            |\n| `RESOURCE_008`     | Webhook not found                              |\n| **Business Logic** |                                                |\n| `BUSINESS_001`     | Cannot modify inherited contact                |\n| `BUSINESS_002`     | Rate limit exceeded                            |\n| `BUSINESS_003`     | Insufficient account balance                   |\n| `BUSINESS_004`     | Contact has opted out of messaging             |\n| `BUSINESS_005`     | Template not approved for sending              |\n| `BUSINESS_006`     | Message cannot be modified in current state    |\n| `BUSINESS_007`     | Channel not available for this contact         |\n| `BUSINESS_008`     | Operation would exceed quota                   |\n| **Conflict**       |                                                |\n| `CONFLICT_001`     | Concurrent idempotent request in progress      |\n| **Service**        |                                                |\n| `SERVICE_001`      | Cache service temporarily unavailable          |\n| **Internal**       |                                                |\n| `INTERNAL_001`     | Unexpected internal server error               |\n| `INTERNAL_002`     | Database operation failed                      |\n| `INTERNAL_003`     | External service error (SMS/WhatsApp provider) |\n| `INTERNAL_004`     | Timeout waiting for operation                  |\n| `INTERNAL_005`     | Service temporarily unavailable                |")
        url.set("https://docs.sent.dm")

        licenses {
            license {
                name.set("Apache-2.0")
            }
        }

        developers {
            developer {
                name.set("Sent Dm")
                email.set("support@sent.dm")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/sentdm/sent-dm-java.git")
            developerConnection.set("scm:git:git://github.com/sentdm/sent-dm-java.git")
            url.set("https://github.com/sentdm/sent-dm-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
