package klyrics

import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RoutingTest {

    @Test
    fun shouldGetHomepage() = assertSucceded("/")

    @Test
    fun shouldSearchSongs() = assertSucceded("/song/search?category=Pop&language=Italian")

    @Test
    fun shouldShowSong() = assertSucceded("/song/code")

    private fun assertSucceded(uri: String) {
        withTestApplication(Application::klyrics) {
            with(handleRequest(HttpMethod.Get, uri)) {
                assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
            }
        }
    }
}
