package klyrics

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.routing.*

fun Application.klyrics() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(Application::class.java.classLoader, "templates")
    }

    routing {
        get("/") {
            val useCase = HomepageUseCase(InMemorySongsRepository())
            val model = mapOf(
                    "categories" to useCase.categories(),
                    "languages" to useCase.languages())
            call.respond(FreeMarkerContent("homepage.ftl", model, contentType = ContentType.Text.Html))
        }
        get("/song/search") {
            val useCase = ListSongsUseCase(InMemorySongsRepository())
            val model = mapOf(
                    "songs" to useCase.searchBy(call.parameters["category"]!!, call.parameters["language"]!!))
            call.respond(FreeMarkerContent("songs.ftl", model, contentType = ContentType.Text.Html))
        }
        get("/song/{code}") {
            call.respond(FreeMarkerContent("song.ftl", emptyMap<String, String>(), contentType = ContentType.Text.Html))
        }
    }
}

