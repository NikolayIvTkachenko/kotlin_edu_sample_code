package org.example.patterns.behavior_patterns.memento

class Manager {
    private var lastThought = "Should get some coffee"
    private var repeatThat = 3
    private var thenHesitate = "Or maybe tea?"
    private var secretThought = "No, cofee it is"

    fun whatAreYouThinking() {
        for(i in 1..repeatThat) {
            println(lastThought)
        }
        println(thenHesitate)
    }

    fun anotherThought() {
        lastThought = "Tea would be better"
        repeatThat = 2
        thenHesitate = "But coffee is also nice"
        secretThought = "Big latte would be great"
    }

    data class CapturedThought(val thought: String, val repeat: Int, val hesitate: String, val secret: String)

    inner class Thought {
        fun captureThought(): CapturedThought {
            return CapturedThought(lastThought, repeatThat, thenHesitate, secretThought)
        }
    }
}

fun main() {

    val michael = Manager()
    val captured = michael.Thought().captureThought()
    michael.whatAreYouThinking()
    michael.anotherThought()
    michael.whatAreYouThinking()

}