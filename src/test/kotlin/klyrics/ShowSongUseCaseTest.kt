package klyrics

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ShowSongUseCaseTest {

    val songsRepository: SongsRepository = mockk()
    val lyricsRepository: LyricsRepository = mockk()

    @Test
    fun shouldFindLyrics() {
        every { songsRepository.all() } returns listOf(
                Song("Jovanotti", "Bella", "Rap", "Italian"))

        every { lyricsRepository.get("Jovanotti", "Bella") } returns "the text";

        val song = ShowSongUseCase(songsRepository, lyricsRepository).load("jovanotti-bella")

        assertThat(song.lyrics).contains("the text")
    }
}