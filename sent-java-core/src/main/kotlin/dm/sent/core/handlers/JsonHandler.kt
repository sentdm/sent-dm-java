@file:JvmName("JsonHandler")

package dm.sent.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponse.Handler
import dm.sent.errors.SentInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw SentInvalidDataException("Error reading response", e)
            }
    }
