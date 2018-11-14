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
            val content = FreeMarkerContent("homepage.ftl", emptyMap<String, String>(), contentType = ContentType.Text.Html)
            call.respond(content)
        }
    }
}

