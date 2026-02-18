// File generated from our OpenAPI spec by Stainless.

package dm.sent.errors

import dm.sent.core.JsonValue
import dm.sent.core.http.Headers

abstract class SentDmServiceException
protected constructor(message: String, cause: Throwable? = null) : SentDmException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
