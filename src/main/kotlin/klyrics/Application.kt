package klyrics

import io.ktor.application.*
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.TimeUnit

lateinit var server: NettyApplicationEngine

fun main(args : Array<String>) {
    start()
}

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
            val text = """
                <input type="text" id="input-title">
                <input type="text" id="input-author">
                <button type="submit" id="button-search">
            """.trimMargin()
            call.respondText(text, ContentType.Text.Html)
        }
    }
}
