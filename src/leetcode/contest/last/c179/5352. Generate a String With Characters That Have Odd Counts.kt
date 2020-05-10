package leetcode.contest.last.c179

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5352()
    s.generateTheString(4).print()
    s.generateTheString(5).print()
}

class Solution5352 {
    fun generateTheString(n: Int): String {
        var ans = ""
        val i = n % 2 == 0
        for (j in 0..n - 2) {
            ans += 'a'
        }
        ans += if (i) {
            'b'
        } else {
            'a'
        }
        return ans
    }
}