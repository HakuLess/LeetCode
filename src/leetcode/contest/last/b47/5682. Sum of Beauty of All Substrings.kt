package leetcode.contest.last.b47

class Solution5682 {
    fun beautySum(s: String): Int {
        var ans = 0
        for (i in s.indices) {
            val cur = IntArray(26)
            for (j in i until s.length) {
                cur[s[j] - 'a']++
                ans += cur.filter { it != 0 }.max()!! - cur.filter { it != 0 }.min()!!
            }
        }
        return ans
    }
}