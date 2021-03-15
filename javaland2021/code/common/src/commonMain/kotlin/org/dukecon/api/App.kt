package org.dukecon.api

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import org.dukecon.api.models.Event

@Composable
fun App(events: List<Event>) {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("DukeCon") })
            }) {
            Column {
                LazyColumn {
                    /*
                    items(events) { event ->
                        Text(event.start ?: "Event")
                    }

                     */
                }
            }
        }
    }
}
