package org.example.threads_coroutines

data class Profile(
   val bio: String,
   val picture: ByteArray?,
   val friends: List<String>?,
) {}