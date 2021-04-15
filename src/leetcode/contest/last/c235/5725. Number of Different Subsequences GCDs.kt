package leetcode.contest.last.c235

import leetcode.contest.utils.gcd
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5725()
    s.countDifferentSubsequenceGCDs(intArrayOf(3, 6, 10)).print()
}

class Solution5725 {
    fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
        val seen = BooleanArray(200001) { false }
        nums.forEach { seen[it] = true }
        var ans = 0
        for (i in 1..200000) {
            var cur = -1
            for (j in i..200000 step i) {
                if (seen[j]) {
                    cur = if (cur == -1) j else gcd(cur, j)
                    if (cur == i) {
                        ans++
                        break
                    }
                }
            }
        }
        return ans
    }
}