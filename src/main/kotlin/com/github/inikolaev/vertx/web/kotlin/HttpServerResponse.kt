package com.github.inikolaev.vertx.web.kotlin

import io.vertx.core.http.HttpServerResponse
import io.vertx.core.json.JsonObject

fun HttpServerResponse.endJson(json: JsonObject) = this.end(json.encode())
