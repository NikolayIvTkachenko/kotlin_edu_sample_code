package org.example.patterns.behavior_patterns.visitor



sealed class LivingCreature
interface Visitor {
    fun visit(creature: LivingCreature)
}
class Human(val name: String): LivingCreature()
class Cat(val colour: String): LivingCreature()

class Guest : Visitor{
    override fun visit(creature : LivingCreature) = when(creature) {
        is Human -> println( "Поздоровайся с ${creature.name}")
        is Cat -> println( "Погладь котика (это который ${creature.colour} ) ")
    }
}

fun main() {
    val human: LivingCreature = Human("Сергей")
    val cat  : LivingCreature = Cat("рыжий")
    Guest().visit(human )
    Guest().visit( cat )

}