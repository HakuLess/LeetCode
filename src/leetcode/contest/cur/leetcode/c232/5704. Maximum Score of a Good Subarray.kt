package leetcode.contest.cur.leetcode.c232

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5704()
//    s.maximumScore(intArrayOf(1, 4, 3, 7, 4, 5), 3).print()
    s.maximumScore(intArrayOf(5, 5, 4, 5, 4, 1, 1, 1), 0).print()
}

class Solution5704 {
    fun maximumScore(nums: IntArray, k: Int): Int {
        val min = IntArray(nums.size)
        for (i in k downTo 0) {
            if (i == k) min[k] = nums[k]
            else min[i] = minOf(min[i + 1], nums[i])
        }
        for (i in k until nums.size) {
            if (i == k) min[k] = nums[k]
            else min[i] = minOf(min[i - 1], nums[i])
        }
        var ans = 0
        var l = 0
        var r = nums.lastIndex
        while (k in l..r && l in min.indices && r in min.indices) {
            ans = maxOf(ans, (r - l + 1) * minOf(min[l], min[r]))
            if (min[l] < min[r]) l++
            else r--
        }
        return ans
    }
}