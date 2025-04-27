package org.example.structures.tree

import org.example.structures.queue.ArrayListQueue

typealias Visitor<T> = (TreeNodeV0<T>) -> Unit

//It is very very strange construction
class TreeNodeV0<T>(val value: T) {

    private val children: MutableList<TreeNodeV0<T>> = mutableListOf()

    fun add(child: TreeNodeV0<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)

        children.forEach{
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)

        val queue = ArrayListQueue<TreeNodeV0<T>>()

        children.forEach {
            queue.enqueue(it)
        }
        var node = queue.dequeue()

        while(node != null) {
            visit(node)

            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNodeV0<T>? {
        var result: TreeNodeV0<T>? = null

        forEachDepthFirst {
            if(it.value == value) {
                result = it
                println("Found value ${it.value}")
            }
        }
        return result
    }


}