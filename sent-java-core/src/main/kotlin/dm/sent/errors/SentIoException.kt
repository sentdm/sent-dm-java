package dm.sent.errors

class SentIoException @JvmOverloads constructor(message: String? = null, cause: Throwable? = null) :
    SentException(message, cause)
