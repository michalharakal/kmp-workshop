package org.dukecon.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.ktor.util.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.dukecon.api.DukeconApi
import org.dukecon.common.DukeconRepository
import org.dukecon.presentation.EventsList
import org.dukecon.presentation.EventsViewModel

@InternalAPI
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initClient()

        setContent {
            EventsList(statusScreenViewModel)
        }
    }

    val repository = DukeconRepository()

    class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return creator() as T
        }
    }


    
    val statusScreenViewModel: EventsViewModel by lazy {
        ViewModelProvider(
            this,
            BaseViewModelFactory { EventsViewModel(repository) }
        ).get(EventsViewModel::class.java)
    }


    private fun initClient() {
        val dukeconApi = DukeconApi(engine = createUnsecureOkHttpClient(application))

        GlobalScope.launch {
            val events = dukeconApi.getEvents()
            repository.updateEvents(events)
        }
    }
}