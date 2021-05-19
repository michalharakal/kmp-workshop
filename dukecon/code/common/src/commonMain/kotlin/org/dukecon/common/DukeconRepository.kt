package org.dukecon.common

import kotlinx.coroutines.flow.Flow
import org.dukecon.api.models.Event

class DukeconRepository {

    inner class EventsStateModel : ValueModel<List<Event>>(emptyList())

    private val _eventsStateModel = EventsStateModel()

    val eventsStateModel: Flow<List<Event>>
        get() = _eventsStateModel.model

    fun updateEvents(value: List<Event>) {
        _eventsStateModel.setValue(value)
    }
}
