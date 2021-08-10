package leetcode.contest.last.b58

import leetcode.contest.utils.manacher
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5220()
    s.maxProduct("aaaaaaaaaa").print()
}

class Solution5220 {
    // 回文字符串
    // 马拉车算法
    fun maxProduct(s: String): Long {
        val n = s.length
        val len = manacher(s)
        val left = LongArray(n) { 1 }
        var p = 0
        for (i in 1 until n) {
            // 以i为右边界的最长回文长度
            while (p + len[p] < i) p++
            left[i] = maxOf(left[i - 1], 1L + 2L * (i - p))
        }
        val right = LongArray(n) { 1 }
        p = n - 1
        for (i in n - 2 downTo 0) {
            // 以i为左边界的最长回文长度
            while (p - len[p] > i) p--
            right[i] = maxOf(right[i + 1], 1L + 2L * (p - i))
        }
        var ans = 1L
        for (i in 0 until n - 1) {
            ans = maxOf(ans, left[i] * right[i + 1])
        }
        return ans
    }
}