package leetcode

import leetcode.learn.TNode
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun TreeNode?.depth(): Int = if (this == null) {
    0
} else {
    1 + maxOf(left.depth(), right.depth())
}

inline fun List<Suffix>.printSuffix() {
    this.forEach {
        println("${it.suff}, ${it.index}")
    }
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
        println("key: $t, value: $u")
    }
}

class Interval(
        var start: Int = 0,
        var end: Int = 0
)

// Definition for a binary tree node.
class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//  Definition for singly-linked list.
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

/**
 * 并查集 Union-Find Set
 *
 * @link https://hakuless.github.io/post/union-find-set/
 */
class UFS(var n: Int = 0) {
    private val parent = IntArray(n) { i -> i }
    private val rank = IntArray(n)

    fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val px = find(x)
        val py = find(y)
        if (px == py) {
            return false
        }
        when {
            rank[px] > rank[py] -> parent[py] = px
            rank[px] < rank[py] -> parent[px] = py
            else -> {
                parent[px] = py
                rank[px]++
            }
        }
        return true
    }
}

class TypedUFS<T>(var n: Int = 0) {
    private val parent = IntArray(n) { i -> i }
    private val rank = IntArray(n)

    val map = hashMapOf<T, Int>()
    var total = 0

    fun typedFind(key: T): Int {
        var x = total
        if (map.containsKey(key)) {
            x = map[key]!!
        } else {
            map[key] = total
            total++
        }
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    private fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: T, y: T): Boolean {
        val px = typedFind(x)
        val py = typedFind(y)
        if (px == py) {
            return false
        }
        when {
            rank[px] > rank[py] -> parent[py] = px
            rank[px] < rank[py] -> parent[px] = py
            else -> {
                parent[px] = py
                rank[px]++
            }
        }
        return true
    }
}

class Suffix(
        val index: Int,
        val suff: String,
        val rank: IntArray
)

class SuffixArray(str: String) {
    private val suffixes = ArrayList<Suffix>()

    private var ans: List<Suffix>

    init {
        var sb = ""
        for (i in str.lastIndex downTo 0) {
            sb = str[i] + sb
            val rank = IntArray(2)
            rank[0] = str[i] - 'a'
            rank[1] = if (i == str.lastIndex) {
                -1
            } else {
                str[i + 1] - 'a'
            }
            val item = Suffix(i, sb, rank)
            suffixes.add(item)
        }

        ans = suffixes.sortedWith(compareBy({ it.rank[0] }, { it.rank[1] }))
    }

    fun getSuffixArray(): List<Suffix> {
        return ans
    }
}

/**
 * 最长公共前缀
 * */
fun lcp(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var prefix = strs[0]
    for (i in 1 until strs.size) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
            if (prefix.isEmpty()) {
                return ""
            }
        }
    }
    return prefix
}