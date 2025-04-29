package org.example.patterns.factory.abstract_factory

interface Building<in UnitType, out ProduceUnit> where UnitType: Enum<*>, ProduceUnit: Unit {
    fun build(type: UnitType): ProduceUnit
}

class Barracks: Building<InfantryUnits, Infantry> {
    override fun build(type: InfantryUnits): Infantry {
        return when(type) {
            InfantryUnits.RIFLEMAN -> Rifleman()
            InfantryUnits.ROCKET_SOLDIER -> RocketSoldier()
        }
    }
}

class VehicleFactory: Building<VehicleUnits, Vehicle> {
    override fun build(type: VehicleUnits): Vehicle {
        return when(type) {
            VehicleUnits.TANK -> Tank()
            VehicleUnits.APC -> APC()
        }
    }
}

class HQ {
    val building = mutableListOf<Building<*, Unit>>()

    fun buildingBarracks(): Barracks {
        val b = Barracks()
        building.add(b)
        return b
    }

    fun buildVehicleFactory(): VehicleFactory {
        val vf = VehicleFactory()
        building.add(vf)
        return vf
    }
}

//---------------------
interface HQV2 {
    fun buildBarracks(): Building<InfantryUnits, Infantry>
    fun buildVehicleFactory(): Building<VehicleUnits, Vehicle>
}

class CatHQ: HQV2 {

    val building = mutableListOf<Building<*, Unit>>()
    override fun buildBarracks(): Building<InfantryUnits, Infantry> {
        val b = object: Building<InfantryUnits, Infantry> {
            override fun build(type: InfantryUnits): Infantry {
                return when(type) {
                    InfantryUnits.RIFLEMAN -> Rifleman()
                    InfantryUnits.ROCKET_SOLDIER -> RocketSoldier()
                }
            }
        }
        building.add(b)
        return b;
    }

    override fun buildVehicleFactory(): Building<VehicleUnits, Vehicle> {
        val vf = object: Building<VehicleUnits, Vehicle> {
            override fun build(type: VehicleUnits): Vehicle {
                return when(type) {
                    VehicleUnits.APC -> APC()
                    VehicleUnits.TANK -> Tank()
                }
            }
        }
        building.add(vf)
        return vf
    }
}
