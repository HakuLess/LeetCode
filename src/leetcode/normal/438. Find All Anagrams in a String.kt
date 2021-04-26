package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution438()
    s.findAnagrams("cbaebabacd", "abc").joinToString().print()
}

class Solution438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val target = IntArray(26)
        p.forEach {
            target[it - 'a']++
        }
        val ans = arrayListOf<Int>()
        val n = p.length
        for (i in s.indices) {
            target[s[i] - 'a']--
            if (i >= n) {
                target[s[i - n] - 'a']++
            }
            if (target.all { it == 0 }) {
                ans.add(i - n + 1)
            }
        }
        return ans
    }
}