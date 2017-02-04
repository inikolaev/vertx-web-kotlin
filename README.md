# vertx-web-kotlin

This library provides Kotlin extension functions for Vert.X Router to make it easier to define routes.

## Example



```kotlin
import com.github.inikolaev.vertx.web.kotlin.*
import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    val router = Router.router(vertx)
    
    router.get("/user/:name") { context ->
        val user = context.request().getParam("name")
        context.response().end("Hello $user!")
    }
    
    router.get { context ->
        context.response().end("Hello World!")
    }
    
    vertx.createHttpServer().requestHandler { router.accept(it) }.listen(8080)
}
```