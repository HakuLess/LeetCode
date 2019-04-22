package leetcode.contest.c133

import leetcode.print


fun main(args: Array<String>) {
    val s = Solution1029()
}

class Solution1029 {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        var ans = 0
        val size = costs.size
        costs.sortedBy {
            it[0] - it[1]
        }.forEachIndexed { index, ints ->
            ans += if (index < size / 2) {
                ints[0]
            } else {
                ints[1]
            }
        }

        return ans
    }
}