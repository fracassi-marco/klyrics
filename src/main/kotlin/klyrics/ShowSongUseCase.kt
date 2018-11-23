package klyrics

class ShowSongUseCase(private val songsRepository: SongsRepository, private val lyricsRepository: LyricsRepository) {

    fun load(code: String) : Song {
        val song = songsRepository.all().single { it.code() == code }
        enrichWithLyrics(song)
        return song
    }

    private fun enrichWithLyrics(song: Song) {
        song.lyrics = lyricsRepository.get(song.author, song.title)
    }
}
