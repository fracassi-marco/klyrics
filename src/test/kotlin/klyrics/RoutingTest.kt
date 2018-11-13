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
    fun testRequest(): Unit = withTestApplication(Application::klyrics) {
        with(handleRequest(HttpMethod.Get, "/")) {
            assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
        }
    }
}
