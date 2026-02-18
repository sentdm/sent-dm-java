// File generated from our OpenAPI spec by Stainless.

package com.sent_dm.api.errors

import com.sent_dm.api.core.JsonValue
import com.sent_dm.api.core.http.Headers

abstract class SentDmServiceException
protected constructor(message: String, cause: Throwable? = null) : SentDmException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
