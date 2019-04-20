package leetcode.normal

import leetcode.print
import kotlin.math.max

fun main(args: Array<String>) {
    val array = arrayOf("hello", "leetcode")
    val order = "hlabcdefgijkmnopqrstuvwxyz"
    isAlienSorted(array, order).print()
}

fun isAlienSorted(words: Array<String>, order: String): Boolean {
    for (i in 0 until words.size - 1) {
        if (!compareAlien(words[i], words[i + 1], order)) {
            return false
        }
    }
    return true
}

fun compareAlien(s1: String, s2: String, order: String): Boolean {
    val size = max(s1.length, s2.length)
    for (i in 0 until size) {
        if (order.indexOf(s1.getOrElse(i) { 'a' - 1 }) >
                order.indexOf(s2.getOrElse(i) { 'a' - 1 })) {
            return false
        } else if (order.indexOf(s1.getOrElse(i) { 'a' - 1 }) <
                order.indexOf(s2.getOrElse(i) { 'a' - 1 })) {
            return true
        }
    }
    return true
}