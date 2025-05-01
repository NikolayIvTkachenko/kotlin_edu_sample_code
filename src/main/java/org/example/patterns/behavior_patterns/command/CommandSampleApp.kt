package org.example.patterns.behavior_patterns.command

interface Command {
    fun execute()
}

class MoveForward(val s: Soldier): Command {
    override fun execute() {
        s.move(s.positionX+10, s.positionY)
    }
}

class AttackForward(val s: Soldier): Command {
    override fun execute() {
        s.attack(s.positionX+50, s.positionY)
    }
}

class Soldier {
    var positionX: Long = 0
    var positionY: Long = 0
    private val orders = mutableListOf<Command>()

    fun anotherOrder(action: Command) {
        this.orders.add(action)
    }

    fun execute() {
        while (!orders.isEmpty()) {
            val action = orders.removeAt(0)
            action.execute()
        }
    }

    //Action Unit
    fun attack(x: Long, y: Long) {
        println("Atacking ( $x, $y )")
    }

    fun move (x: Long, y: Long) {
        println("Moving to ( $x, $y)")
    }
}

fun main() {

    val soldier = Soldier()
    val moveForward = MoveForward(soldier)
    val attackForward = AttackForward(soldier)

    soldier.anotherOrder(moveForward)
    soldier.anotherOrder(attackForward)

    soldier.execute()


}