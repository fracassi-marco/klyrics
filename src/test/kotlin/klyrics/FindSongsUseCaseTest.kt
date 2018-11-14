package klyrics

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FindSongsUseCaseTest {

    val repository: SongsRepository = mockk()

    @Test
    fun shouldFilterByLanguageAndCategory() {
        every { repository.all() } returns listOf(
                Song("Jovanotti", "Bella", "Rap", "Italian"),
                Song("Shandon", "Nice Try", "Ska", "Italian"),
                Song("U2", "Pride", "Rock", "English"))

        val songs = FindSongsUseCase(repository).searchBy("Ska", "Italian")

        assertThat(songs.first().author).isEqualTo("Shandon")
    }
}