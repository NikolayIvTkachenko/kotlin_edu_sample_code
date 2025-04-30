package org.example.patterns.structures_patterns

fun main() {
    println()
    println("==== program01 ====")
    println()
    program01()
    println()
    println("==== program02 ====")
    println()
    program02()

}


data class Json(val j: String)

operator fun Json.plus(j2: Json): Json {
    val jsonFields = this.j.split(":") + j2.j.split(":")
    val s = (jsonFields).joinToString (":")
    return Json("""{$s}""")
}

fun program02() {
    val j1 = Json("""{"a": "b"}""")
    val j2 = Json("""{"a": "b"}""")
    println(j1 + j2)
}

fun program01() {
    val a = listOf("a")
    val b = listOf("b")
    println(a + b)
}
