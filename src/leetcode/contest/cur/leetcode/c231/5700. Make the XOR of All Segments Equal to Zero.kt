package leetcode.contest.cur.leetcode.c231

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5700()
    s.minChanges(intArrayOf(3, 4, 5, 2, 1, 7, 3, 4, 7), 3).print()
}

class Solution5700 {
    fun minChanges(nums: IntArray, k: Int): Int {
        var c = 0
        for (i in 0 until k) {
            c = c xor nums[i]
        }
        var ans = Int.MAX_VALUE
        val tmp = IntArray(k)
        for (i in 0 until k) {
            for (i in 0 until k) {
                tmp[i] = nums[i]
            }
            var cur = 0
            if (tmp[i] != (c xor nums[i])) {
                cur++
            }
            tmp[i] = c xor nums[i]
            for (i in 0 until nums.size) {
                if (nums[i] != nums[i % k]) {
                    cur++
                }
            }
            ans = minOf(ans, cur)
        }
        return ans
    }
}