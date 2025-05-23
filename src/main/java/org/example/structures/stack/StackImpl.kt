package org.example.structures.stack

class StackImpl<T: Any>: Stack<T> {

    private var storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun peek(): T? {
        return storage.firstOrNull()
    }

    override fun pop(): T? {
        return storage.removeFirstOrNull()
    }

    override fun push(element: T) {
        storage.add(element)
    }

}

fun String.isValidParentheses(): Boolean {
    val stack = StackImpl<Char>()

    for(char in this) {
        when(char) {
            '(' -> {
                stack.push(char)
            }
            ')' -> {
                if(stack.isEmpty)
                    return false
                else {
                    stack.pop()
                }
            }
        }
    }
    return stack.isEmpty
}