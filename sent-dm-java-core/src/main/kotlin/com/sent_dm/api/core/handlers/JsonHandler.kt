@file:JvmName("JsonHandler")

package com.sent_dm.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.sent_dm.api.core.http.HttpResponse
import com.sent_dm.api.core.http.HttpResponse.Handler
import com.sent_dm.api.errors.SentDmInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw SentDmInvalidDataException("Error reading response", e)
            }
    }
