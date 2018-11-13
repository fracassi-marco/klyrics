package klyrics

import io.ktor.application.*
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.TimeUnit

fun Application.klyrics() {
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

