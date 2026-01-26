package com.sent_dm.api.errors

open class SentDmException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
