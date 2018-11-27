package klyrics

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LyricsOvhLyricsRepositoryTest {
    @Test
    fun shouldMakeSearch() {
        runBlocking {
            val lyrics = LyricsOvhLyricsRepository().get("U2", "Pride")

            assertThat(lyrics).contains("in the name of love")
        }
    }
}