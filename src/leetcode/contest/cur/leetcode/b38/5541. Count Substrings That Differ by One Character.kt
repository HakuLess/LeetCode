package leetcode.contest.cur.leetcode.b38

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5541()
    s.countSubstrings("abe", "bbc").print()
}

class Solution5541 {
    fun countSubstrings(s: String, t: String): Int {
        var ans = 0
        for (i in s.indices) {
            for (j in i + 1 until s.length + 1) {
                val n = j - i
                for (k in 0 until t.length - n + 1) {
                    if (s.substring(i, j).zip(t.substring(k, k + n)).count {
                                it.first != it.second
                            } == 1) {
                        ans++
                    }
                }
            }
        }
        return ans
    }
}