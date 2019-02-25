package leetcode

import java.util.*

inline fun String.print() {
    println("String is " + this)
}

inline fun Int.print() {
    println("Int is " + this)
}

inline fun Long.print() {
    println("Long is " + this)
}

fun TNode.print() {
    println("level: ${this.level}, value: ${this.`val`}")
    for (child in this.child) {
        child.print()
    }
}

inline fun ListNode?.print() {
    var node = this
    while (node != null) {
        node.`val`.print()
        node = node.next
    }
}

inline fun List<List<Int>>.print() {
    this.forEach {
        it.forEach {
            print("$it, ")
        }
        println()
    }
}

inline fun IntArray.print() {
    this.forEach {
        print("$it, ")
    }
    println()
}

inline fun Boolean.print() {
    println(this)
}

inline fun TreeMap<Int, Int>.print() {
    this.forEach { t, u ->
        kotlin.io.println("key: $t, value: $u")
    }
}