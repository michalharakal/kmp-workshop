package org.dukecon.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import org.dukecon.presentation.EventsViewModel

@Composable
fun EventsList(events: EventsViewModel) {

    val statusScreenVal = events.statusInputs.collectAsState(
        emptyList(),
        events.clientScope.coroutineContext
    )

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("DukeCon") })
            }) {
            Column {
                LazyColumn {
                    items(statusScreenVal.value.size) { eventIndex ->
                        Text(statusScreenVal.value[eventIndex].title ?: "Event")
                    }
                }
            }
        }
    }
}
