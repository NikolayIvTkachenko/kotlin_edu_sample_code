package org.example.patterns.structures_patterns.bridge

interface Infantry {
    fun move(x: Long, y: Long)

    fun attack(x: Long, y: Long)
}

open class Rifleman: Infantry {
    override fun attack(x: Long, y: Long) {
        //Shoot
    }

    override fun move(x: Long, y: Long) {
        //Move at its own pace
    }
}

open class Grenadier: Infantry {
    override fun move(x: Long, y: Long) {
        //Throw grenades
    }

    override fun attack(x: Long, y: Long) {
        //Moves slowly, grenades are heavy
    }
}


class UpgradedRifleman: Rifleman() {
    override fun attack(x: Long, y: Long) {
        //Shoot twice as muck
    }
}

class UpgradeGrenadier: Grenadier() {
    override fun attack(x: Long, y: Long) {
        //Throw pack of grenades
    }
}

class LightRifleman: Rifleman() {
    override fun move(x: Long, y: Long) {
        //Running with rifle
    }
}

class LightGrenadier: Grenadier() {
    override fun move(x: Long, y: Long) {
        //I've been to gym, pack of grenades is no problem
    }
}

//-----------------------------------------------------------------------
//===How it will be correct/right===
typealias PointsOfDamage = Long
typealias Meters = Int

const val GRENADE_DAMAGE: PointsOfDamage = 5L
const val RIFLE_DAMAGE = 3L
const val REGULAR_SPEED: Meters = 1


interface Weapon {
    fun causeDamage(): PointsOfDamage
}

interface Legs {
    fun move(): Meters
}

class Soldier(
    private val weapon: Weapon,
    private val legs: Legs,
) : Infantry {
    override fun move(x: Long, y: Long) {
        //Find target
        //Shoot
        weapon.causeDamage()
    }

    override fun attack(x: Long, y: Long) {
        //Compute direction
        //Move at its own pace
        legs.move()
    }
}

class Grenade: Weapon {
    override fun causeDamage(): PointsOfDamage {
        return GRENADE_DAMAGE
    }
}

class GrenadePack: Weapon {
    override fun causeDamage(): PointsOfDamage {
        return GRENADE_DAMAGE * 3
    }
}

class Rifle: Weapon {
    override fun causeDamage(): PointsOfDamage {
        return RIFLE_DAMAGE
    }
}

class MachineGun: Weapon {
    override fun causeDamage(): PointsOfDamage {
        return RIFLE_DAMAGE * 2
    }
}

class RegularLegs: Legs {
    override fun move(): Meters {
        return REGULAR_SPEED
    }
}

class AthleticLegs: Legs {
    override fun move(): Meters {
        return REGULAR_SPEED * 2
    }
}
//-----------------------------

fun main() {

    program01()

}

fun program01() {
    val rifleman = Soldier(Rifle(), RegularLegs())
    val grenadier = Soldier(Grenade(), RegularLegs())
    val upgradedGrenadier = Soldier(MachineGun(), RegularLegs())
    val upgradeRifleman = Soldier(MachineGun(), RegularLegs())
    val lightRifleman = Soldier(Rifle(), AthleticLegs())
    val lightGrenadier = Soldier(Grenade(), AthleticLegs())

}