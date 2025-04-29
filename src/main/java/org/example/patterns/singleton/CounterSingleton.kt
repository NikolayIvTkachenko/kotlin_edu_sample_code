package org.example.patterns.singleton

import java.util.concurrent.atomic.AtomicInteger

object CounterSingleton {

    init {
        println("Counter Singleton created")
    }

    private val counter = AtomicInteger(0)
    fun increment() = counter.incrementAndGet()



}