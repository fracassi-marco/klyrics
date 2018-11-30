package klyrics

import io.ktor.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    KLyrics().start()
}

class KLyrics {

    lateinit var server: NettyApplicationEngine

    fun start() {
        server = embeddedServer(Netty, port = 8080, module = {
            klyrics(InMemorySongsRepository(), LyricsOvhLyricsRepository())
        })
        server.start(wait = false)
    }

    fun stop() {
        server.stop(1, 2, TimeUnit.SECONDS)
    }
}