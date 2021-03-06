package leetcode.contest.cur.leetcode.b47

class Solution5682 {
    fun beautySum(s: String): Int {
        var ans = 0
        for (i in s.indices) {
            val cur = IntArray(26) { -1 }
            for (j in i until s.length) {
                cur[s[j] - 'a']++
                ans += cur.filter { it != -1 }.max()!! - cur.filter { it != -1 }.min()!!
            }
        }
        return ans
    }
}