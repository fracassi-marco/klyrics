package klyrics

interface SongsRepository {
    fun all() : List<Song>
}
