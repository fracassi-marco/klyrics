package klyrics

import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.call.receive
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature

class LyricsOvhLyricsRepository : LyricsRepository{
    override suspend fun get(author: String, title: String): String {
        val client = HttpClient(Apache) {
            install(JsonFeature)
        }

        val body = client.call("https://api.lyrics.ovh/v1/$author/$title").receive<SearchResponse>()

        client.close()

        return body.lyrics
    }

}

data class SearchResponse(val lyrics: String)
