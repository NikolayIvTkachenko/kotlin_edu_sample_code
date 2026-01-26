package org.example.threads_coroutines

fun main() {
    program01()
}

fun program01() {
    val filtered : List<Int> = (1..100).filter { it % 3 == 0 || it % 5 == 0 }
    println(filtered)


}