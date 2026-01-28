package org.example.threads_rxjava


import io.reactivex.Observable
import io.reactivex.rxkotlin.*

fun main() {
    programm01_rxjava()
}

fun programm01_rxjava() {
    var list01: List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f)
    var observable: Observable<Any> = list01.toObservable()

     observable.subscribeBy(
         onNext = {
             println(it)
         },
         onError = {
             it.printStackTrace()
         },
         onComplete = {
             println("Done")
         }
     )

}


fun programm02_rxjava() {
   //var subject: Subject<int>


}