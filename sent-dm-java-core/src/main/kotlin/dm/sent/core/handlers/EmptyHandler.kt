@file:JvmName("EmptyHandler")

package dm.sent.core.handlers

import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
