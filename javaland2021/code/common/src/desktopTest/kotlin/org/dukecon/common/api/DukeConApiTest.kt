package org.dukecon.common.api

import kotlinx.coroutines.runBlocking
import org.dukecon.api.DukeconApi
import org.junit.Test
import kotlin.test.assertTrue

class DukeconApiTest {
    @Test
    fun testJavaland() {
        val api = DukeconApi()
        runBlocking<Unit> {
            val events = api.getEvents()
            assertTrue { events.isNotEmpty() }
        }
    }
}
