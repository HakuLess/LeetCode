package leetcode

import leetcode.learn.TNode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun TreeNode?.depth(): Int = if (this == null) {
    0
} else {
    1 + maxOf(left.depth(), right.depth())
}

inline fun Array<Suffix>.printSuffix() {
    this.forEachIndexed { index, suffix ->
        println("$index: ${suffix.index}")
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

inline fun HashMap<Int, Int>.printInt() {
    this.forEach {
        println("${it.key} : ${it.value}")
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

/**
 * 倍增法，后缀数组
 * */
class Suffix(
        var index: Int,
        var rank: IntArray
)

class SuffixArray(private val str: String) {
    private val n = str.length
    private var suffixes = Array(n) { Suffix(0, IntArray(2)) }

    private val compare = compareBy<Suffix>({ it.rank[0] }, { it.rank[1] })

    init {
        for (i in 0 until n) {
            suffixes[i].rank[0] = str[i] - 'a'
            suffixes[i].rank[1] = if (i < n - 1) str[i + 1] - 'a' else -1
            suffixes[i].index = i
        }

        suffixes = suffixes.sortedWith(compare).toTypedArray()

        val ind = IntArray(n)

        var k = 4
        while (k < 2 * n) {
            var rank = 0
            var preRank = suffixes[0].rank[0]
            suffixes[0].rank[0] = rank
            ind[suffixes[0].index] = 0

            for (i in 1 until n) {
                if (suffixes[i].rank[0] == preRank && suffixes[i].rank[1] == suffixes[i - 1].rank[1]) {
                    preRank = suffixes[i].rank[0]
                    suffixes[i].rank[0] = rank
                } else {
                    preRank = suffixes[i].rank[0]
                    suffixes[i].rank[0] = ++rank
                }
                ind[suffixes[i].index] = i
            }

            for (i in 0 until n) {
                val nextIndex = suffixes[i].index + k / 2
                suffixes[i].rank[1] = if (nextIndex < n) {
                    suffixes[ind[nextIndex]].rank[0]
                } else {
                    -1
                }
            }

            suffixes = suffixes.sortedWith(compare).toTypedArray()
            k *= 2
        }
    }

    fun getSuffixArray(): Array<Suffix> {
        return suffixes
    }

    fun kasai(): Array<Int> {
        val lcp = Array(n) { 0 }
        val invSuff = Array(n) { 0 }

        for (i in 0 until n) {
            invSuff[suffixes[i].index] = i
        }

        var k = 0
        for (i in 0 until n) {
            if (invSuff[i] == n - 1) {
                k = 0
                continue
            }

            val j = suffixes[invSuff[i] + 1].index

            while (i + k < n && j + k < n && str[i + k] == str[j + k]) {
                k++
            }

            lcp[invSuff[i]] = k

            if (k > 0) {
                k--
            }
        }

        return lcp
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