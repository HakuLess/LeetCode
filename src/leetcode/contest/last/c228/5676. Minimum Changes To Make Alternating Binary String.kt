package leetcode.contest.last.c228

class Solution5676 {
    fun minOperations(s: String): Int {
        fun dfs(ch: Char): Int {
            var ans = 0
            for (i in s.indices) {
                if ((i % 2 == 0) xor (s[i] == ch)) {
                    ans++
                }
            }
            return ans
        }
        return minOf(dfs('0'), dfs('1'))
    }
}