package leetcode.contest.cur.leetcode.c238

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5740()
    s.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu").print()
}

class Solution5740 {
    fun longestBeautifulSubstring(word: String): Int {
        val c = charArrayOf('a', 'e', 'i', 'o', 'u')
        var ans = 0
        var cur = IntArray(5)
        for (i in word.indices) {
            val index = c.indexOf(word[i])
            for (j in c.lastIndex downTo 0) {
                if (index == j) {
                    cur[index]++
                    break
                } else if (cur[j] != 0) {
                    if (cur.all { it != 0 }) {
                        ans = maxOf(ans, cur.sum())
                    }
                    cur = IntArray(5)
                }
            }
            cur.print()
        }
        if (cur.all { it != 0 }) {
            ans = maxOf(ans, cur.sum())
        }
        return ans
    }
}