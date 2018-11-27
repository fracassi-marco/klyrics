package klyrics

import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ShowSongUseCaseTest {

    val songsRepository: SongsRepository = mockk()
    val lyricsRepository: LyricsRepository = mockk()

    @Test
    fun shouldFindLyrics() {
        every { songsRepository.all() } returns listOf(
                Song("Jovanotti", "Bella", "Rap", "Italian"))

        coEvery {  lyricsRepository.get("Jovanotti", "Bella") } returns "the text";

        runBlocking {
            val song = ShowSongUseCase(songsRepository, lyricsRepository).load("jovanotti-bella")
            assertThat(song.lyrics).contains("the text")
        }
    }
}