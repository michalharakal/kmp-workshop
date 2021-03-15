package org.dukecon.api

import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import org.dukecon.api.models.Event


class DukeconApi(
    private val endpoint: String = "https://programm.javaland.eu/2021/rest",
    private val conferenceId: String = "javaland2021"
) {

    private val client = HttpClient {
        install(JsonFeature) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
            serializer = KotlinxSerializer(Json { isLenient = true; ignoreUnknownKeys = true })
        }
    }

    suspend fun getEvents(): List<Event> =
        client.get("$endpoint/conferences/$conferenceId/events")
}