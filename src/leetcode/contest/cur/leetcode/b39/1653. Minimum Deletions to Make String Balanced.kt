package leetcode.contest.cur.leetcode.b39

class Solution1653 {
    fun minimumDeletions(s: String): Int {
        val a = IntArray(s.length)
        val b = IntArray(s.length)
        for (i in s.indices) {
            when {
                i == 0 -> a[i] = if (s[i] == 'a') 1 else 0
                s[i] == 'a' -> {
                    a[i] = a[i - 1] + 1
                }
                else -> {
                    a[i] = a[i - 1]
                }
            }
        }

        for (i in s.indices.reversed()) {
            when {
                i == s.lastIndex -> b[i] = if (s[i] == 'b') 1 else 0
                s[i] == 'b' -> {
                    b[i] = b[i + 1] + 1
                }
                else -> {
                    b[i] = b[i - 1]
                }
            }
        }

        var ans = 0
        for (i in s.indices) {
            ans = minOf(ans, s.length - a[i] - b[i])
        }
        return ans
    }
}