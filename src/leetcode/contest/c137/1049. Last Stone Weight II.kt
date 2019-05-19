package leetcode.contest.c137

import leetcode.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution1049()
    s.lastStoneWeightII(intArrayOf(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 14, 23, 37, 61, 98)).print()
}

class Solution1049 {
    fun lastStoneWeightII(stones: IntArray): Int {
        val sum = stones.sum()
        val array = BooleanArray(sum + 1)
        array[0] = true
        var ans = sum
        for (stone in stones) {
            var j = sum
            while (j - stone >= 0) {
                array[j] = array[j] || array[j - stone]
                if (array[j]) {
                    ans = minOf(ans, abs(j - (sum - j)))
                }
                j--
            }
        }
        return ans
    }
}