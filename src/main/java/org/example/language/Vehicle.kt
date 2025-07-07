package org.example.language

data class Vehicle(
    val name: String,
    val massa: Int,
) {
    var color: String? = null

}


fun main() {

    val car = Vehicle("xxx", 1000).also {
        it.color = "Red"
    }

    println(car)
    println(car.color)



}