package com.github.inikolaev.vertx.web.kotlin

/**
 * Created by inikolaev on 04/02/2017.
 */

import io.vertx.core.Vertx

fun main(args: Array<String>) {
    val vertx = Vertx.vertx()

    vertx.httpServer(8080) {
        get("/user/:name") { context ->
            val user = context.request().getParam("name")
            context.response().end("Hello $user!")
        }

        get { context ->
            context.response().end("Hello World!")
        }
    }
}
