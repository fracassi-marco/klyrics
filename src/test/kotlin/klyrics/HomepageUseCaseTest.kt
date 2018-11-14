package klyrics

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HomepageUseCaseTest {

    private val repository: SongsRepository = mockk()

    @Test
    fun shouldPopulateCategorySelects() {
        every { repository.all() } returns listOf(
                Song("foo", "foo", "Rap", "Italian"),
                Song("bar", "bar", "Ska", "Italian"),
                Song("baz", "baz", "Rap", "English"))

        val categories = HomepageUseCase(repository).categories()

        assertThat(categories).containsAll(listOf("Rap", "Ska"))
    }

    @Test
    fun shouldPopulateLanguageSelects() {
        every { repository.all() } returns listOf(
                Song("foo", "foo", "Rap", "Italian"),
                Song("bar", "bar", "Ska", "Italian"),
                Song("baz", "baz", "Rap", "English"))

        val categories = HomepageUseCase(repository).languages()

        assertThat(categories).containsAll(listOf("Italian", "English"))
    }
}