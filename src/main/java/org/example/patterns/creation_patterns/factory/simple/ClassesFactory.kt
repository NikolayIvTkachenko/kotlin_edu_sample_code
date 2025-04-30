package org.example.patterns.creation_patterns.factory.simple

import java.lang.RuntimeException


interface Animal {
    val id: Int
    val name: String
}

class Cat(override val id: Int) : Animal {
    override val name = "Cat"
    override fun toString(): String {
        return name
    }
}

class Dog(override val id: Int)  : Animal {
    override val name = "Dog"
    override fun toString(): String {
        return name
    }
}


fun animalFactory(animalType: String): Animal {
    var counter = 0
    return when (animalType.toLowerCase()) {
        "cat" -> Cat(counter++)
        "dog" -> Dog(counter++)
        else -> throw RuntimeException("Unknown animal $")
    }
}

class AnimalFactory {
    var counter = 0
    fun createAnimal(animalType: String): Animal {
        return when (animalType.trim().toLowerCase()) {
            "cat" -> Cat(counter++)
            "dog" -> Dog(counter++)
            else -> throw RuntimeException("Unknown animal $")
        }
    }
}

