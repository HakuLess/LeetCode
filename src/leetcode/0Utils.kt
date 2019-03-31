package leetcode

import java.util.*
import kotlin.collections.HashMap

fun TreeNode?.depth(): Int = if (this == null) {
    0
} else {
    1 + maxOf(left.depth(), right.depth())
}

inline fun Array<DoubleArray>.print() {
    this.forEach {
        it.forEach {
            print("$it, ")
        }
        println()
    }
    println()
}

inline fun Stack<Char>.print() {
    this.forEach {
        print("$it, ")
    }
    println()
}

inline fun HashMap<String, Int>.print() {
    this.forEach {
        println("${it.key} : ${it.value}")
    }
    println()
}

inline fun Array<IntArray>.print() {
    this.forEach {
        it.forEach {
            print("$it, ")
        }
        println()
    }
    println()
}

inline fun Array<BooleanArray>.print() {
    this.forEach {
        it.forEach {
            print("$it, ")
        }
        println()
    }
    println()
}

inline fun ArrayList<Pair<Int, Int>>.print() {
    this.forEach {
        println("${it.first}, ${it.second}")
    }
    println()
}

inline fun String.print() {
    println("String is " + this)
}

inline fun Int.print() {
    println("Int is " + this)
}

inline fun Long.print() {
    println("Long is " + this)
}

inline fun Double.print() {
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

inline fun BooleanArray.print() {
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

class Interval(
        var start: Int = 0,
        var end: Int = 0
)