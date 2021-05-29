package leetcode.contest.cur.leetcode.b53

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5754()
    s.countGoodSubstrings("xyzzaz").print()
    s.countGoodSubstrings("aababcabc").print()
}

class Solution5754 {
    fun countGoodSubstrings(s: String): Int {
        if (s.length < 2) return 0
        var ans = 0
        val arr = IntArray(26)
        for (i in s.indices) {
            arr[s[i] - 'a']++
            arr.print()
            if (arr.all { it == 0 || it == 1 } && arr.sum() == 3) ans++
            if (i - 2 >= 0) {
                arr[s[i - 2] - 'a']--
            }
        }
        return ans
    }
}