package org.example.threads_rxjava


import io.reactivex.Observable
import io.reactivex.rxkotlin.*
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject


fun main() {
    programm01_rxjava()
    programm02_rxjava()




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

fun isEven(n: Int): Boolean = true

fun programm02_rxjava() {
   var subject: Subject<Int> = PublishSubject.create()
    subject.map({isEven(it)}).subscribe { m ->
        println("The number is ${(if (m) "Even" else "Odd")}")
    }
    subject.onNext(4)
    subject.onNext(9)

}