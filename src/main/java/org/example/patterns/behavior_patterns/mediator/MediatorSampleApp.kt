package org.example.patterns.behavior_patterns.mediator

interface QA {
    fun doesMyCodeWork(): Boolean
}

interface Parrot {
    fun isEating(): Boolean
    fun isSleeping(): Boolean
}

object Kenny: QA, Parrot {
    override fun doesMyCodeWork(): Boolean {
        return true
    }

    override fun isEating(): Boolean {
        return false
    }

    override fun isSleeping(): Boolean {
        return false
    }
}

class MyMind {
    val qa = Kenny
    fun taskCompleted() {
        if(!qa.isEating() && !qa.isSleeping()) {
            println(qa.doesMyCodeWork())
        }
    }
}