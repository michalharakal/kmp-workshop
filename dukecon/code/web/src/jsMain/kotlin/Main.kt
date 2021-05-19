import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.web.css.padding
import androidx.compose.web.css.px
import androidx.compose.web.elements.Button
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.Span
import androidx.compose.web.elements.Text
import androidx.compose.web.renderComposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.dukecon.api.DukeconApi
import org.dukecon.api.models.Event
import org.dukecon.common.DukeconRepository


fun main() {
    val sessions = mutableStateOf("")

    val repository: DukeconRepository = DukeconRepository()
    GlobalScope.launch {
        val events: List<Event> = DukeconApi().getEvents()
        repository.updateEvents(events)
        repository.eventsStateModel.collect { events ->
            sessions.value = events.joinToString("<\br>") { it.title ?: "" }

        }
    }

    //val events = repository.eventsStateModel.collectAsState(emptyList(), GlobalScope.coroutineContext)


    renderComposable(rootElementId = "root") {
        Div(style = { padding(25.px) }) {
            Button(
                attrs = {
                    onClick {
                        //count.value = Room("4", "Room minus")
                        //log(LogLevel.DEBUG, "Web", "minus")
                    }
                }) { Text("-") }

            //Span(style = { padding(15.px) }) { Text("${events.value[0].title}") }

            Button(
                attrs = {
                    onClick {
                        //count.value = Room("4", "Room plus")
                        //log(LogLevel.DEBUG, "Web", "plus")
                    }
                }) { Text("+") }
            Button(
                attrs = {
                    onClick {


                    }
                }) { Text("get sessions") }
        }
        Div { Text(sessions.value) }
    }
}
