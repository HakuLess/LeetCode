package leetcode.contest.last.c165

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5278()
    s.palindromePartition("abc", 2).print()
    s.palindromePartition("aabbc", 3).print()
    s.palindromePartition("leetcode", 8).print()
}

class Solution5278 {
    val seen = HashMap<Pair<String, Int>, Int>()
    fun palindromePartition(s: String, k: Int): Int {
        return helper(s, k)
    }

    private fun helper(s: String, k: Int): Int {
//        println("cal $s, $k")
        if (Pair(s, k) in seen) {
            return seen[Pair(s, k)]!!
        }
        if (k > s.length) {
            return Int.MAX_VALUE / 2
        }
        if (k == s.length) {
            return 0
        }
        if (k == 1) {
            return getS(s)
        }
        var ans = Int.MAX_VALUE / 2
        for (i in 1..s.lastIndex) {
            val cur = s.substring(0, i)
            ans = minOf(ans, helper(s.substring(i, s.length), k - 1) + getS(cur))
        }
        seen[Pair(s, k)] = ans
//        println("$s, $k : $ans")
        return ans
    }

    private fun getS(s: String): Int {
        var a = 0
        var b = s.lastIndex
        var ans = 0
        while (a < b) {
            if (s[a] != s[b]) {
                ans++
            }
            a++
            b--
        }
        return ans
    }
}