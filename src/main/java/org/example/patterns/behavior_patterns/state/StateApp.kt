package org.example.patterns.behavior_patterns.state

interface WhatCanHappen {
    fun seeHero()
    fun getHit(pointOfDamage: Int)
    fun calmAgain()
}

sealed class Mood {
    class Still: Mood()
    class Aggressive: Mood()
    class Retreating: Mood()
    class Dead: Mood()
}

class Snail: WhatCanHappen {
    private var healthPoints = 10

    private var mood: Mood = Mood.Still()
    override fun seeHero() {
        mood = when(mood) {
            is Mood.Still -> Mood.Aggressive()
            is Mood.Aggressive -> mood
            is Mood.Retreating -> mood
            else -> mood
        }
    }

    override fun getHit(pointOfDamage: Int) {
        healthPoints -= pointOfDamage
        mood = when {
            (healthPoints <= 0) -> Mood.Dead()
            mood is Mood.Aggressive -> Mood.Retreating()
            else -> mood
        }
    }

    override fun calmAgain() {
        mood = Mood.Still()
    }
}