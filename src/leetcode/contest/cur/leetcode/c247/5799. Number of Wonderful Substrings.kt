package leetcode.contest.cur.leetcode.c247

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5799()
//    s.wonderfulSubstrings("aba").print()
//    s.wonderfulSubstrings("he").print()
    s.wonderfulSubstrings("aabb").print()
}

class Solution5799 {
    fun wonderfulSubstrings(word: String): Long {
        val state = IntArray(1 shl 10)
        state[0] = 1
        var cur = 0
        var ans: Long = 0
        for (c in word) {
            cur = cur xor (1 shl (c - 'a'))
            // 无偶数个
            ans += state[cur]
            // 仅有一个偶数个
            for (i in 0..9) {
                ans += state[cur xor (1 shl i)]
            }
            state[cur]++
        }
        return ans
    }
}