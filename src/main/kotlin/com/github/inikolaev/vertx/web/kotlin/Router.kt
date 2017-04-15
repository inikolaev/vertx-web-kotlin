package com.github.inikolaev.vertx.web.kotlin

import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.impl.RouterImpl

/**
 * Created by inikolaev on 04/02/2017.
 */

inline fun Vertx.httpServer(options: HttpServerOptions = HttpServerOptions(), block: Router.() -> Unit) {
    httpServer(HttpServerOptions.DEFAULT_PORT, options, block)
}

inline fun Vertx.httpServer(port: Int, options: HttpServerOptions = HttpServerOptions(), block: Router.() -> Unit) {
    val router = Router.router(this)
    router.block()
    httpServer(port, options, router)
}

inline fun Vertx.httpServer(router: Router, options: HttpServerOptions = HttpServerOptions()) {
    httpServer(HttpServerOptions.DEFAULT_PORT, options, router)
}

inline fun Vertx.httpServer(port: Int, router: Router, options: HttpServerOptions = HttpServerOptions()) {
    createHttpServer(options).requestHandler { router.accept(it) }.listen(port)
}

fun Router.cors(pattern: String) : Route = route(CorsHandler.create(pattern)
        .allowedMethod(HttpMethod.GET)
        .allowedHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS.toString())
        .allowedHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS.toString())
        .allowedHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS.toString())
        .allowedHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN.toString())
        .allowedHeader(HttpHeaders.CONTENT_TYPE.toString())
        .allowedHeader("X-FLOW-ID")
        .allowCredentials(true))

fun Router.route(handler: (RoutingContext) -> Unit) : Route = route().handler(handler)
fun Router.route(method: HttpMethod, path: String, handler: (RoutingContext) -> Unit) : Route = route(method, path).handler(handler)
fun Router.route(path: String, handler: (RoutingContext) -> Unit) : Route = route(path).handler(handler)
fun Router.routeWithRegex(method: HttpMethod, path: String, handler: (RoutingContext) -> Unit) : Route = routeWithRegex(method, path).handler(handler)
fun Router.routeWithRegex(path: String, handler: (RoutingContext) -> Unit) : Route = routeWithRegex(path).handler(handler)

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
