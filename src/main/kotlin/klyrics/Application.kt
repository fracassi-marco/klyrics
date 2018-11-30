package klyrics

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.ContentType
import io.ktor.http.content.*
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.util.pipeline.PipelineContext
import java.io.File

fun Application.klyrics(songsRepository: SongsRepository, lyricsRepository: LyricsRepository) {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(Application::class.java.classLoader, "templates")
    }

    val path = System.getProperty("user.dir")

    println("Working Directory = $path")

    routing {
        get("/") {
            val useCase = HomepageUseCase(songsRepository)
            val model = mapOf(
                    "categories" to useCase.categories(),
                    "languages" to useCase.languages())
            respondAsHtml("homepage", model)
        }
        get("/song/search") {
            val useCase = ListSongsUseCase(songsRepository)
            val model = mapOf(
                    "songs" to useCase.searchBy(call.parameters["category"]!!, call.parameters["language"]!!))
            respondAsHtml("songs", model)
        }
        get("/song/{code}") {
            val song = ShowSongUseCase(songsRepository, lyricsRepository).load(call.parameters["code"]!!)
            val model = mapOf(
                    "song" to song)
            respondAsHtml("song", model)
        }
        static("assets") {
            staticRootFolder = File("src/main/resources")
            files("assets")
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.respondAsHtml(view: String, model: Any? = null) {
    call.respond(asHtml(model, view))
}

private fun asHtml(model: Any?, view: String ) =
        FreeMarkerContent("$view.ftl", model, contentType = ContentType.Text.Html)

