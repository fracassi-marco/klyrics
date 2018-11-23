package klyrics

interface LyricsRepository {
    fun get(author: String, title: String): String
}
