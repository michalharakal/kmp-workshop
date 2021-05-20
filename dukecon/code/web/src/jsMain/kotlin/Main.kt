import androidx.compose.runtime.mutableStateOf
import androidx.compose.web.elements.Text
import androidx.compose.web.renderComposable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.dukecon.api.DukeconApi
import org.dukecon.common.DukeconRepository
import org.jetbrains.compose.common.foundation.layout.Column
import org.jetbrains.compose.common.foundation.layout.Row

fun main() {
    val conferenceEventsState = mutableStateOf(listOf<String>())

    val repository = DukeconRepository()
    GlobalScope.launch {
        repository.updateEvents(DukeconApi().getEvents())
        repository.eventsStateModel.collect { events ->
            conferenceEventsState.value = events.map { it.title!! }
        }
    }

    renderComposable(rootElementId = "root") {
        Text("Dukecon")
        Column {
            conferenceEventsState.value.forEach { session ->
                Row {
                    Text(session)
                }
            }
        }
    }
}
