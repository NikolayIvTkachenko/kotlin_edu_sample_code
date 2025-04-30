package org.example.patterns.structures_patterns.adapter

interface EUPlug

interface UsbMini

interface UsbTypeC

interface USPlug

fun cellPhone(chargeCable: UsbTypeC) {
    //do something
}

fun powerOutlet(): USPlug {
    return object : USPlug {}
}

fun charger(plug: EUPlug): UsbMini {
    return object : UsbMini{}
}

//Convert Adapters
fun USPlug.toEUPlug(): EUPlug {
    return object: EUPlug {
        //Do something to convert
    }
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    return object: UsbTypeC {
        //Do something ro convert
    }
}

fun main() {
    cellPhone(charger(powerOutlet().toEUPlug()).toUsbTypeC())
}




