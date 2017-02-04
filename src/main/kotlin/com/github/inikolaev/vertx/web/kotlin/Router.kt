package com.github.inikolaev.vertx.web.kotlin

import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext

/**
 * Created by inikolaev on 04/02/2017.
 */

fun Router.get(handler: (RoutingContext) -> Unit) : Route = get().handler(handler)
fun Router.get(path: String, handler: (RoutingContext) -> Unit) : Route = get(path).handler(handler)
fun Router.getWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = getWithRegex(regex).handler(handler)

fun Router.head(handler: (RoutingContext) -> Unit) : Route = head().handler(handler)
fun Router.head(path: String, handler: (RoutingContext) -> Unit) : Route = head(path).handler(handler)
fun Router.headWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = headWithRegex(regex).handler(handler)

fun Router.options(handler: (RoutingContext) -> Unit) : Route = options().handler(handler)
fun Router.options(path: String, handler: (RoutingContext) -> Unit) : Route = options(path).handler(handler)
fun Router.optionsWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = optionsWithRegex(regex).handler(handler)

fun Router.put(handler: (RoutingContext) -> Unit) : Route = put().handler(handler)
fun Router.put(path: String, handler: (RoutingContext) -> Unit) : Route = put(path).handler(handler)
fun Router.putWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = putWithRegex(regex).handler(handler)

fun Router.post(handler: (RoutingContext) -> Unit) : Route = post().handler(handler)
fun Router.post(path: String, handler: (RoutingContext) -> Unit) : Route = post(path).handler(handler)
fun Router.postWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = postWithRegex(regex).handler(handler)

fun Router.delete(handler: (RoutingContext) -> Unit) : Route = delete().handler(handler)
fun Router.delete(path: String, handler: (RoutingContext) -> Unit) : Route = delete(path).handler(handler)
fun Router.deleteWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = deleteWithRegex(regex).handler(handler)

fun Router.trace(handler: (RoutingContext) -> Unit) : Route = trace().handler(handler)
fun Router.trace(path: String, handler: (RoutingContext) -> Unit) : Route = trace(path).handler(handler)
fun Router.traceWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = traceWithRegex(regex).handler(handler)

fun Router.connect(handler: (RoutingContext) -> Unit) : Route = connect().handler(handler)
fun Router.connect(path: String, handler: (RoutingContext) -> Unit) : Route = connect(path).handler(handler)
fun Router.connectWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = connectWithRegex(regex).handler(handler)

fun Router.patch(handler: (RoutingContext) -> Unit) : Route = patch().handler(handler)
fun Router.patch(path: String, handler: (RoutingContext) -> Unit) : Route = patch(path).handler(handler)
fun Router.patchWithRegex(regex: String, handler: (RoutingContext) -> Unit) : Route = patchWithRegex(regex).handler(handler)