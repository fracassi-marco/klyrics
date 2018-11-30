package klyrics

import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RoutingTest {

    val songsRepository: SongsRepository = mockk()
    val lyricsRepository: LyricsRepository = mockk()

    @Test
    fun shouldGetHomepage() = assertSucceded("/")

    @Test
    fun shouldSearchSongs() = assertSucceded("/song/search?category=Pop&language=Italian")

    @Test
    fun shouldShowSong() = assertSucceded("/song/the-code")

    private fun assertSucceded(uri: String) {
        every { songsRepository.all() } returns listOf(Song("the", "code", "Rap", "Italian"))
        coEvery { lyricsRepository.get("the", "code") } returns "the text";

        withTestApplication({ klyrics(songsRepository, lyricsRepository) }) {
            with(handleRequest(HttpMethod.Get, uri)) {
                assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
            }
        }
    }
}
