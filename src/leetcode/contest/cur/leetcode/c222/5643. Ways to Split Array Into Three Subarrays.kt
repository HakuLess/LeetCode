package leetcode.contest.cur.leetcode.c222

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5643()
    s.waysToSplit(intArrayOf(1, 2, 2, 2, 5, 0)).print()
    s.waysToSplit(intArrayOf(1, 1, 1)).print()
    s.waysToSplit(intArrayOf(0, 3, 3)).print()
}

class Solution5643 {
    fun waysToSplit(nums: IntArray): Int {
        val n: Int = nums.size
        val psum = IntArray(n + 1)
        for (i in 0 until n) {
            psum[i + 1] = psum[i] + nums[i]
        }
        var res = 0
        var a = 1
        var b = 1
        for (i in 0 until n - 2) {
            a = maxOf(i + 1, a)
            while (a < n - 1 && psum[a + 1] - psum[i + 1] < psum[i + 1]) {
                a++
            }
            if (a == n - 1) {
                break
            }
            b = maxOf(b, a)
            while (b < n - 1 && psum[n] - psum[b + 1] >= psum[b + 1] - psum[i + 1]) {
                b++
            }
            res = (res + (b - a)) % 1000000007
        }
        return res
    }
}