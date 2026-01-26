package org.example.threads_coroutines

fun main() {
    // program01()
    // program02()
    program03_sequences()
}

fun program01() {
    val filtered : List<Int> = (1..100).filter { it % 3 == 0 || it % 5 == 0 }
    println(filtered)

    val found: Int? = (1..100).find { it % 3 == 0 && it % 5 == 0 }
    println(found)


    val numbers01 = (0..5)
    numbers01.map { it * it}
        .filter { it < 20 }
        .forEach { print("$it ") }

    println()

    numbers01.map { it * it }
        .forEachIndexed { index, i ->  print("$index:$i ") }

    println()

    val reduced: Int = (1..100).sum()
    println(reduced)

    val reduced01: Int = (1..100).reduce { sum, n -> sum }
    println(reduced01)

    val reduced02: Int = (1..100).reduce { sum, n -> sum + n}
    println(reduced02)

    println()
    println()

    val concatenated = listOf("Test", "program", "usually").reduce { acc, s -> "$acc $s" }
    println(concatenated)
    println()

    val factorial = (1..5).reduce { product, n -> product * n}
    println(factorial)
    println()

    val fold01: Int = (1..100).fold(10) { sum, n -> sum + n}
    println(fold01)

    val scan01: List<Int> = (1..100).scan(0) { sum, n -> sum + n}
    println(scan01)

    val fold02: Int = (1..100).fold(0) { sum, n -> sum + n}
    println(fold02)
}

fun program02() {

    val listOfLists: List<List<Int>> = listOf(listOf(1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
    println(listOfLists)

    // THE SAME
    val flattened01: List<Int> = listOfLists.flatMap { it }
    println(flattened01)

    // THE SAME
    val flattened02: List<Int> = listOfLists.flatten()
    println(flattened02)

}

fun program03_sequences() {

    // Бесконечная генерация последовательности
    // val seq: Sequence<Long> = generateSequence(1L) { it + 1 }
    // println(seq)

    val seq02 = (1..100).asSequence()
    println(seq02)

    val seq03 = sequence {
        var a = 0
        var b = 1
        yield(a)
        yield(b)
        while(true) {
            yield(a + b)
            val t = a
            a = b
            b += t
        }
    }
    println(seq03)


}