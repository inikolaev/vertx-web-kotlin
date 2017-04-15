# vertx-web-kotlin

This library provides Kotlin extension functions for Vert.X Web to make it easier to define routes and work with requests and responses.

## Examples

#### Using `Router` extension functions to define routes

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

#### Using `Vertx.httpServer` extension function to create server and define routes

```kotlin
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
```

#### Enabling CORS

```kotlin
import com.github.inikolaev.vertx.web.kotlin.*
import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    
    vertx.httpServer(8080) {
        cors("*")

        get("/user/:name") { context ->
            val user = context.request().getParam("name")
            context.response().end("Hello $user!")
        }
    }
}
```

#### Responding with JSON

```kotlin
import com.github.inikolaev.vertx.web.kotlin.*
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj

fun main(args: Array<String>) {
    val vertx = Vertx.vertx()

    vertx.httpServer(8080) {
        get("/user/:name") { context ->
            val user = context.request().getParam("name")
            context.response().endJson(json {
                obj("name" to name)
            })
        }
    }
}
```
