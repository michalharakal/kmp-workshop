package org.dukecon.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.dukecon.api.App
import org.dukecon.api.DukeconApi
import org.dukecon.common.DukeconRepository
import org.dukecon.presentation.EventsViewModel

class MainActivity : AppCompatActivity() {

    class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return creator() as T
        }
    }

    private val repository: DukeconRepository = DukeconRepository()

    val statusScreenViewModel: EventsViewModel by lazy {
        ViewModelProvider(
            this,
            BaseViewModelFactory { EventsViewModel(repository) }
        ).get(EventsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            val events = DukeconApi().getEvents()
            repository.updateEvents(events)
        }
        setContent {
            App(statusScreenViewModel)
        }
    }
}