package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution44()
    s.isMatch("aa", "a").print()
    s.isMatch("aa", "*").print()
    s.isMatch("cb", "?a").print()
    s.isMatch("adceb", "*a*b").print()
    s.isMatch("acdcb", "a*c?b").print()
    s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a******b").print()
}

class Solution44 {
    val seen = HashMap<Pair<String, String>, Boolean>()

    fun isMatch(s: String, p: String): Boolean {
        return if (p.isNotEmpty()) {
            var ps = p[0].toString()
            for (i in 1..p.lastIndex) {
                if (p[i] == p[i - 1] && p[i] == '*') {
                    continue
                } else {
                    ps += p[i]
                }
            }
            helper(s, ps)
        } else {
            s.isEmpty()
        }
    }

    private fun helper(s: String, p: String): Boolean {
        val ans: Boolean
        if (s.isEmpty()) {
            ans = p.all { it == '*' } || p.isEmpty()
            seen[Pair(s, p)] = ans
            return ans
        }
        if (p.isEmpty()) {
            ans = false
            seen[Pair(s, p)] = ans
            return false
        }
        if (s[0] == p[0] || p[0] == '?') {
            ans = isMatch(s.substring(1), p.substring(1))
            seen[Pair(s, p)] = ans
            return ans
        } else if (p[0] == '*') {
            var isMatch = false
            for (i in 0..s.length) {
                isMatch = isMatch || isMatch(s.substring(i), p.substring(1))
                if (isMatch) {
                    ans = isMatch
                    seen[Pair(s, p)] = ans
                    return true
                }
            }
            ans = isMatch
            seen[Pair(s, p)] = ans
            return false
        }
        ans = false
        seen[Pair(s, p)] = ans
        return false
    }
}