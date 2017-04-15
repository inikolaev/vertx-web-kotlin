package com.github.inikolaev.vertx.web.kotlin

import io.vertx.core.Future
import io.vertx.ext.web.client.HttpRequest

fun <T> HttpRequest<T>.send(): Future<T> {
    val future = Future.future<T>()

    try {
        this.send {
            it.map {
                future.complete(it.body())
            }.otherwise {
                future.fail(it)
            }
        }
    } catch (e: Exception) {
        future.fail(e)
    }

    return future
}
