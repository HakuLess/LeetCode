package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution646()
    s.findLongestChain(arrayOf(
            intArrayOf(-10, -8),
            intArrayOf(8, 9),
            intArrayOf(-5, 0),
            intArrayOf(-6, -4),
            intArrayOf(1, 7),
            intArrayOf(9, 10),
            intArrayOf(-4, 7),
            intArrayOf(6, 10)
    )).print()
//    s.findLongestChain(arrayOf(
//            intArrayOf(1, 2),
//            intArrayOf(1, 6),
//            intArrayOf(2, 3),
//            intArrayOf(3, 4)
//    )).print()
}

class Solution646 {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortBy { it.last() }
        var ans = 1

        var tail = pairs[0].last()
        for (i in 1 until pairs.size) {
            print("$tail, ")
            if (pairs[i].first() > tail) {
                ans++
                tail = pairs[i].last()
            }
        }
        return ans
    }
}