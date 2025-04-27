package org.example.delegate

import kotlin.reflect.KProperty

//https://kotlinlang.ru/docs/delegated-properties.html

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Example {
    var p: String by Delegate()
}

//lazy() — это функция, которая принимает лямбду и возвращает экземпляр класса Lazy<T>,
// который служит делегатом для реализации ленивого свойства: первый вызов get() запускает
// лямбда-выражение, переданное lazy() в качестве аргумента, и запоминает полученное значение,
// а последующие вызовы просто возвращают вычисленное значение.
val lazyValue: String by lazy {
    println("Test Test Nick!")
    "Value message"
}
fun main() {
    program001()
    program002()


}
fun program002() {
    println(lazyValue)
}

fun program001() {
    val example = Example()
    example.p = "Test"
    println(example.p)
}