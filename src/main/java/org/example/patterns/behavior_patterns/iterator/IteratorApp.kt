package org.example.patterns.behavior_patterns.iterator

interface InfantryUnit



class Sergeant: InfantryUnit

class Lieutenant: InfantryUnit

class Squad(val infantryUnits: MutableList<InfantryUnit> = mutableListOf()) {
    val commander = Sergeant()
    operator fun iterator() = object : Iterator<InfantryUnit> {
        var i = 0
        override fun hasNext(): Boolean {
            return i < infantryUnits.size + 1
        }

        override fun next(): InfantryUnit {
            return when(i) {
                0 -> commander
                else -> infantryUnits[i-1]
            }.also { i++ }
        }
    }
}

class Platoon(val squads: MutableList<Squad> = mutableListOf()) {
    val commander = Lieutenant()


}



