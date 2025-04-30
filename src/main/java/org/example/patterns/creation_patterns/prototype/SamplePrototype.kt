package org.example.patterns.creation_patterns.prototype


data class PC(
    val motherboard: String = "Terasus XZ27",
    val cpu: String = "Until Atom K500",
    val ram: String = "8GB Microcend BBR5",
    val graphicCard: String = "nKCF 8100TZ"
)

fun main() {

    val pc = PC()
    val pcFromWarehouse = PC()
    val ownerPC = pcFromWarehouse.copy(graphicCard = "nKCF 8999ZTXX", ram = "16 GB BBR6")

    println("<----------->")
    println(pc)
    println()
    println("<----------->")
    println(pcFromWarehouse)
    println()
    println("<----------->")
    println( ownerPC)
    println()
}