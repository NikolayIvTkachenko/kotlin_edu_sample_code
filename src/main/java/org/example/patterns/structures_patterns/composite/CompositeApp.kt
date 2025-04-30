package org.example.patterns.structures_patterns.composite

import java.io.FileFilter

interface InfantryUnit

class Rifleman: InfantryUnit

class Sniper: InfantryUnit

class Squad(val infantryUnits: MutableList<InfantryUnit> = mutableListOf()) {
    constructor(vararg units: InfantryUnit): this(mutableListOf()) {
        for (u in units) {
            this.infantryUnits.add(u)
        }
    }
}

class Bullet

class Magazine(capacity: Int) {
    private val bullets = List(capacity) { Bullet() }
}

fun main() {
    program01()
}

fun program01() {
    val miller = Rifleman()
    val caparzo = Rifleman()
    val jackson = Sniper()

    val squad = Squad()

    squad.infantryUnits.add(miller)
    squad.infantryUnits.add(caparzo)
    squad.infantryUnits.add(jackson)

    val squad2 = Squad(miller, jackson, caparzo)

}