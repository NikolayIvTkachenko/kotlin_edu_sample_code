package org.example.patterns.behavior_patterns.strategy

enum class Direction {
    LEFT, RIGHT
}

abstract class Projectile(
    private val x: Int,
    private val y: Int,
    private val direction: Direction
)

interface Weapon {
    fun shoot(x: Int, y: Int, direction: Direction): Projectile
}

class Peashooter: Weapon {
    override fun shoot(x: Int, y: Int, direction: Direction) = object : Projectile(x, y, direction) {
        //Fly straight
    }
}

class Pomegranate: Weapon {
    override fun shoot(x: Int, y: Int, direction: Direction): Projectile = object : Projectile(x, y, direction) {
        //Explode when you hit first enemy
    }
}

class Bannana: Weapon {
    override fun shoot(x: Int, y: Int, direction: Direction): Projectile = object : Projectile(x, y, direction) {
        //Return when you hit screen border
    }

}

class OurHero {
    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173

    fun shoot(): Projectile {
        return object: Projectile(x, y, direction) {
            //Draw and animate projectile here
        }
    }
}

class OurHeroV2 {
    private var direction = Direction.LEFT
    private var x: Int = 42
    private var y: Int = 173

    private var currentWeapon: Weapon = Peashooter()

    fun shoot(): Projectile  = currentWeapon.shoot(x, y, direction)

    fun equip(weapon: Weapon) {
        currentWeapon = weapon
    }
}
