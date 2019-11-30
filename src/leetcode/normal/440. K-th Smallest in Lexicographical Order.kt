package leetcode.normal

import leetcode.contest.utils.print

// todo not finish
fun main(args: Array<String>) {
    val s = Solution440()
    s.findKthNumber(13, 2).print()
    s.findKthNumber(4289384, 1922239).print()
}

class Solution440 {
    fun findKthNumber(n: Int, k: Int): Int {
        val sort = List(n) { it + 1 }
        return sort.map { it.toString() }.sorted()[k - 1].toInt()
    }
}