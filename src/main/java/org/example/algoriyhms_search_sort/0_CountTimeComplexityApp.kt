package org.example.algoriyhms_search_sort

fun main() {
    programTimeTracker()


}

fun programTimeTracker() {
    val startTime = System.currentTimeMillis().toLong()

    // program001()
    // program002()
    program003()


    val stopTime = System.currentTimeMillis().toLong()
    val elapsedTime: Long = stopTime - startTime

    println("startTime = $startTime")
    println("stopTime = $stopTime")
    println("elapsedTime = $elapsedTime")
}

fun program001() {
    print("Enter an integer : ")
    val ndata = readlnOrNull()?.toInt() ?: 0
    var a = ndata / 100
    var b = (ndata / 10) % 10
    var c = ndata % 10
    var revert = c * 100 + b * 10 + a
    println("a = $a")
    println("b = $b")
    println("c = $c")
    println("revert = $revert")
}

fun program002() {
    print("Enter an integer : ")
    val ndata = readlnOrNull()?.toInt() ?: 0
    var count = 0
    for (i in 1..ndata) {
        print("Enter number : ")
        val ninput = readlnOrNull()?.toInt() ?: 0
        if (ninput % 10 == 0) {
            count += 1
        }
    }
    println("count = $count")
}

fun program003() {
    print("Enter an integer : ")
    val ndata = readlnOrNull()?.toInt() ?: 0
    var count = 0
    var i = 1
    while (i <= ndata * ndata) {
        count++
        i *= 3
    }
    println("count = $count")
}