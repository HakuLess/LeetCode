package leetcode.contest.last.c135

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1040()
    s.numMovesStonesII(
            intArrayOf(1, 4, 5, 6, 10)
    ).print()
}

class Solution1040 {
    fun numMovesStonesII(stones: IntArray): IntArray {
        stones.sort()
        var i = 0
        val n = stones.size
        var low = n
        val high = maxOf(stones[n - 1] - n + 2 - stones[1], stones[n - 2] - stones[0] - n + 2)

        for (j in 0 until n) {
            while (stones[j] - stones[i] >= n) {
                ++i
            }

            low = if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
                minOf(low, 2)
            } else {
                minOf(low, n - (j - i + 1))
            }
        }
        return intArrayOf(low, high)
    }
}