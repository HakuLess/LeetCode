package leetcode.contest.last.c190

class Solution5417 {
    fun maxVowels(s: String, k: Int): Int {
        val set = charArrayOf('a', 'e', 'i', 'o', 'u')
        var ans = 0
        var res = 0
        for (i in s.indices) {
            if (s[i] in set)
                ans += 1
            if (i >= k) {
                if (s[i - k] in set) {
                    ans -= 1
                }
            }
            res = maxOf(res, ans)
        }
        return res
    }
}