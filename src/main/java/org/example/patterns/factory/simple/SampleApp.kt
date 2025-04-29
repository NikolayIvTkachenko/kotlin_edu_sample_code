package org.example.patterns.factory.simple

fun main() {
    val animalCat = animalFactory("cat");
    println(animalCat)

    println("=====================")
    val animalTypes = listOf("dog", "dog", "cat", "dog", "cat", "cat")
    for (t in animalTypes) {
        val c = animalFactory(t)
        println(c)
    }
    println("=====================")
    for (t in animalTypes) {
        val c = animalFactory(t)
        println("${c.id} - ${c.name}")
    }

    println("=====================")
    val animalFactory = AnimalFactory()
    for(t in animalTypes) {
        val c = animalFactory.createAnimal(t)
        println("${c.id} = ${c.name}")
    }

    println("===V2 - Animal Factory ==================")



}