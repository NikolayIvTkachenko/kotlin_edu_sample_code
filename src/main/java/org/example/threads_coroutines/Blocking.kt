package org.example.threads_coroutines

class Blocking {
    companion object {

        fun profile(id: String): Profile {
            val bio = fetchBioOverHttp(id)
            val picture = fetchPictureFromDB(id)
            val friends = fetchFriendsFromDB(id)

            return Profile(bio, picture, friends)
        }

        private fun fetchFriendsFromDB(id: String): List<String> {
            Thread.sleep(500)
            return emptyList()
        }

        private fun fetchPictureFromDB(id: String): ByteArray? {
            Thread.sleep(100)
            return null
        }

        private fun fetchBioOverHttp(id: String): String {
            Thread.sleep(1000)
            return "Nikolay Tkachenko, software Developer"
        }
    }
}