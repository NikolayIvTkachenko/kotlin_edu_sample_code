package org.example.patterns.behavior_patterns.observer


class Bat {
    fun screech() {
        println("Eeeeeeeeee")
    }
}

class Turkey {
    fun gobble() {
        println("God-gob")
    }
}

class Dog {
    fun bark() {
        println("Woof")
    }

    fun howl() {
        println("Auuuu")
    }
}
typealias Times = Int

class Cat {
    private val participants = mutableMapOf<() -> Unit, () -> Unit>()
    fun joinChoir(whatToCall: () -> Unit) {
        participants.put(whatToCall, whatToCall)
    }

    fun leaveChoir(whatToCall: () -> Unit) {
        participants.remove(whatToCall)
    }

    fun conduct(n: Times) {
        for(p in participants.values) {
            for(i in 1..n) {
                p()
            }
        }
    }
}


fun main() {

    val  catTheConductor = Cat()

    val bat = Bat()
    val dog = Dog()
    val turkey = Turkey()

    catTheConductor.joinChoir(bat::screech)
    catTheConductor.joinChoir(dog::howl)
    catTheConductor.joinChoir(dog::bark)
    catTheConductor.joinChoir(turkey::gobble)

    catTheConductor.conduct(4)

}