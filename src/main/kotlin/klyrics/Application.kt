package klyrics

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.util.pipeline.PipelineContext

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
            respondAsHtml("homepage", model)
        }
        get("/song/search") {
            val useCase = ListSongsUseCase(InMemorySongsRepository())
            val model = mapOf(
                    "songs" to useCase.searchBy(call.parameters["category"]!!, call.parameters["language"]!!))
            respondAsHtml("songs", model)
        }
        get("/song/{code}") {
            val song = ShowSongUseCase(InMemorySongsRepository(), LyricsOvhLyricsRepository()).load(call.parameters["code"]!!)
            val model = mapOf(
                    "song" to song)
            respondAsHtml("song", model)
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.respondAsHtml(view: String, model: Any? = null) {
    call.respond(asHtml(model, view))
}

private fun asHtml(model: Any?, view: String ) =
        FreeMarkerContent("$view.ftl", model, contentType = ContentType.Text.Html)

