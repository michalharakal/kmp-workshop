package org.dukecon.presentation

import kotlinx.coroutines.flow.Flow
import org.dukecon.api.models.Event
import org.dukecon.common.DukeconRepository
import org.dukecon.common.CommonViewModel

class EventsViewModel(repository: DukeconRepository): CommonViewModel() {
    val events: Flow<List<Event>> = repository.eventsStateModel
}