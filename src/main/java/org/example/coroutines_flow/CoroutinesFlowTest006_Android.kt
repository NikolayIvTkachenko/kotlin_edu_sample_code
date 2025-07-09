package org.example.coroutines_flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

data class News(val content: String)

interface NewsDao {
    suspend fun fetchNewsFromApi(): List<News>
}

class NewsRepository(private val dao: NewsDao) {
    private val _newsFeed = MutableSharedFlow<News>() //1.4.0
    val newsFeed = _newsFeed.asSharedFlow()

    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    init {
        scope.launch {
            while (true) {
                val news = dao.fetchNewsFromApi()
                news.forEach {
                    _newsFeed.emit(it)
                    delay(3000)
                }
            }
        }
    }
    fun stop() = scope.cancel()
}

val dao = object : NewsDao {
    private var index = 0

    override suspend fun fetchNewsFromApi(): List<News> {
        delay(100)
        return listOf(
            News("News content ${++index}"),
            News("News content ${++index}"),
            News("News content ${++index}"),
            News("News content ${++index}"),
        )
    }
}

//class NewsViewModel(private val repository: NewsRepository): ViewModel() {
//    private val newsList = mutableListOf<News>()
//
//    private val _newsLiveData = MutableLiveData<List<News>>(newsList)
//    val newsLiveData: LiveData<List<News>> = _newsLiveData
//
//    init {
//        viewModelScope.launch {
//            repository.newsFeed.collect {
//                println("NewsViewModel receives $it")
//                newsList.add(it)
//                _newsLiveData.value = newsList
//            }
//        }
//    }
//}