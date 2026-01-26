package org.example.threads_coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class Async {

    private val scope = CoroutineScope(Dispatchers.Default)
    suspend fun profile(id: String): Profile {
        val bio = fetchBioOverHttp(id)
        val picture = withContext(Dispatchers.IO) {
            fetchPictureFromDB(id)
        }
        val friends = fetchFriendsFromDB(id)

        return Profile(bio.await(), picture.await(), friends.await())
    }

    private fun fetchFriendsFromDB(id: String) = scope.async {
        Thread.sleep(500)
        emptyList<String>()
    }

    private fun fetchPictureFromDB(id: String) = scope.async {
        Thread.sleep(100)
        null
    }

    private fun fetchBioOverHttp(id: String) = scope.async {
        Thread.sleep(1000)
        "Nikolay Tkachenko, software Developer"
    }

}