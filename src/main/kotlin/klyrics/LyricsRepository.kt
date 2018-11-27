package klyrics

interface LyricsRepository {
    suspend fun get(author: String, title: String): String
}
