import androidx.compose.desktop.Window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.dukecon.api.App
import org.dukecon.api.DukeconApi
import org.dukecon.common.DukeconRepository
import org.dukecon.presentation.EventsViewModel


fun main() {
    val repository: DukeconRepository = DukeconRepository()
    val statusScreenViewModel: EventsViewModel = EventsViewModel(repository)
    GlobalScope.launch {
        val events = DukeconApi().getEvents()
        repository.updateEvents(events)
    }

    return Window {
        App(statusScreenViewModel)
    }
}