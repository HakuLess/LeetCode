package leetcode.contest.last.c146

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5130()
    s.numEquivDominoPairs(
            arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(5, 6)
            )
    ).print()
}

class Solution5130 {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
        var ans = 0
        val map = hashMapOf<Int, Int>()
        dominoes.forEach {
            it.sort()
        }
        dominoes.map {
            it[0] * 10 + it[1]
        }.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        map.forEach {
            ans += (it.value * (it.value - 1)) / 2
        }
        return ans
    }
}