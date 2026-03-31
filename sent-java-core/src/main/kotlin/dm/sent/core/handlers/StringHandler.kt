@file:JvmName("StringHandler")

package dm.sent.core.handlers

import dm.sent.core.http.HttpResponse
import dm.sent.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
