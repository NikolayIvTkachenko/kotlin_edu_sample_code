package org.example.patterns.factory.abstract_factory

fun main() {
    val hq = HQ()
    val barracks1 = hq.buildingBarracks()
    val barracks2 = hq.buildingBarracks()
    val vehicleFactory1 = hq.buildVehicleFactory()

    val units = listOf(
        barracks1.build(InfantryUnits.RIFLEMAN),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        vehicleFactory1.build(VehicleUnits.TANK),
        vehicleFactory1.build(VehicleUnits.APC),
        vehicleFactory1.build(VehicleUnits.APC),
    )

}