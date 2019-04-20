package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1013()
    s.numPairsDivisibleBy60(intArrayOf(30, 20, 150, 100, 40)).print()
}

class Solution1013 {
    fun numPairsDivisibleBy60(time: IntArray): Int {
        var ans = 0
        for (i in 0 until time.size - 1) {
            for (j in i + 1 until time.size) {
                if ((time[i] + time[j]) % 60 == 0) {
                    ans++
                }
            }
        }
        return ans
    }
}