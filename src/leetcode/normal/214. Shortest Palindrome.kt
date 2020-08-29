package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution214()
    s.shortestPalindrome("aacecaaa").print()
}

class Solution214 {
    fun shortestPalindrome(s: String): String {
        val n: Int = s.length
        val base = 131
        val mod = 1000000007
        var left = 0L
        var right = 0L
        var mul = 1
        var best = -1
        for (i in 0 until n) {
            left = ((left.toLong() * base + s[i].toLong()) % mod)
            right = ((right + mul.toLong() * s[i].toLong()) % mod)
            if (left == right) {
                best = i
            }
            mul = (mul.toLong() * base % mod).toInt()
        }
        val add = if (best == n - 1) "" else s.substring(best + 1)
        val ans = StringBuffer(add).reverse()
        ans.append(s)
        return ans.toString()
    }
}