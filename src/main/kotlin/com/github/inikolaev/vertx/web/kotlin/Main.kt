package com.github.inikolaev.vertx.web.kotlin

/**
 * Created by inikolaev on 04/02/2017.
 */

import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    val router = Router.router(vertx)

    router.get("/kotlin/:name") { context ->
        val user = context.request().getParam("name")
        context.response().end("Hello $user!")
    }

    router.get { context ->
        context.response().end("Hello World!")
    }

    vertx.createHttpServer().requestHandler { router.accept(it) }.listen(8080)
}
