package leetcode.contest.cur.leetcode.c199

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5462()
//    s.getLengthOfOptimalCompression(
//            "aaabcccd", 2
//    ).print()
//    s.getLengthOfOptimalCompression(
//            "aabbaa", 2
//    ).print()
    s.getLengthOfOptimalCompression(
            "abc", 2
    ).print()
}

class Solution5462 {
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val dp = Array<IntArray>(111) { IntArray(111) { Int.MAX_VALUE / 2 } }
        dp[0][0] = 0
        val n = s.length
        for (i in 1..n) {
            for (j in 0..k) {
                dp[i][j + 1] = minOf(dp[i][j + 1], dp[i - 1][j])
                var cnt = 0
                var del = 0
                for (l in i..n) {
                    cnt += if (s[l - 1] == s[i - 1]) 1 else 0
                    del += if (s[l - 1] != s[i - 1]) 1 else 0
                    if (j + del <= k)
                        dp[l][j + del] = minOf(dp[l][j + del],
                                dp[i - 1][j] + 1 + if (cnt >= 100) 3 else if (cnt >= 10) 2 else if (cnt >= 2) 1 else 0)
                }
            }
        }
//        dp.print()
        return dp[n][k]
    }

//    val seen = HashMap<Pair<String, Int>, Int>()
//    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
//        fun dfs(s: String, k: Int): Int {
//            if (Pair(s, k) in seen) {
//                return seen[Pair(s, k)]!!
//            }
//            if (k == 0) {
//                return getRunL(s).length
//            }
//            var min = getRunL(s).length
//            for (i in s.indices) {
//                min = minOf(dfs(s.removeRange(i, i + 1), k - 1), min)
//            }
//            seen[Pair(s, k)] = min
//            return min
//        }
//
//        var str = ""
//        var left = k
//        for (i in s.indices) {
//            if (s.count { it == s[i] } == 1 && left != 0) {
//                left--
//            } else {
//                str += s[i]
//            }
//        }
//        return dfs(str, left)
//    }
//
//    private fun getRunL(str: String): String {
//        val n: Int = str.length
//        var i = 0
//        val ans = StringBuilder()
//        while (i < n) {
//            var count = 1
//            while (i < n - 1 && str[i] == str[i + 1]) {
//                count++
//                i++
//            }
//            ans.append(str[i])
//            if (count != 1) {
//                ans.append(count)
//            }
//            i++
//        }
//        return ans.toString()
//    }
}