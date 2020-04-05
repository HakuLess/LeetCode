package leetcode.contest.cur.c183

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5379()
//    s.stoneGameIII(intArrayOf(1, 2, 3, 7)).print()
//    s.stoneGameIII(intArrayOf(1, 2, 3, -9)).print()
//    s.stoneGameIII(intArrayOf(1, 2, 3, 6)).print()
    s.stoneGameIII(intArrayOf(-1, -2, -3)).print()
}

class Solution5379 {

    private var dp: IntArray? = null

    fun stoneGameIII(stoneValue: IntArray): String {
        val len = stoneValue.size
        dp = IntArray(len) { Int.MIN_VALUE / 2 }
        val sum = stoneValue.sum()
        val max = getMax(stoneValue, 0, sum)
        return when {
            max * 2 > sum -> {
                "Alice"
            }
            max * 2 == sum -> {
                "Tie"
            }
            else -> {
                "Bob"
            }
        }
    }

    private fun getMax(piles: IntArray, i: Int, sum: Int): Int {
        if (i >= piles.size) return 0
        if (dp!![i] == Int.MIN_VALUE / 2) {
            var take = 0
            var max = Int.MIN_VALUE / 2
            var j = 1
            while (j <= 3 && i + j <= piles.size) {
                take += piles[i + j - 1]
                max = maxOf(max, sum - getMax(piles, i + j, sum - take))
                j++
            }
            println("$i, $max")
            dp!![i] = max
        }
        return dp!![i]
    }
}