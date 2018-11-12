package klyrics

import io.ktor.application.*
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.TimeUnit

lateinit var server: NettyApplicationEngine

fun start() {
    server = embeddedServer(Netty, port = 8080) {
        routing()
    }
    server.start(wait = false)
}

fun stop() {
    server.stop(1, 2, TimeUnit.SECONDS)
}

private fun Application.routing() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
