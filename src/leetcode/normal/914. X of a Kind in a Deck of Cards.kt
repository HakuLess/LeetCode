package leetcode.normal

import leetcode.contest.utils.gcd
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution914()
    s.hasGroupsSizeX(intArrayOf(1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3)).print()
}

class Solution914 {
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        if (deck.isEmpty() || deck.size == 1) {
            return false
        }
        val list = deck.groupBy { it }.map {
            it.value.size
        }
        var min = list.min()!!
        list.forEach {
            if (gcd(it, min) == 1) {
                return false
            }
            min = gcd(it, min)
        }
        return true
    }
}