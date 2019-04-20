package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution516()
//    s.longestPalindromeSubseq("bbbab").print()
//    s.longestPalindromeSubseq("cbbd").print()
//    s.longestPalindromeSubseq("bbabab").print()
    s.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew").print()
}

class Solution516 {

    fun longestPalindromeSubseq(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length) }

        for (i in s.lastIndex downTo 0) {
            dp[i][i] = 1
            for (j in i + 1 until s.length) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2
                } else {
                    dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[0][s.lastIndex]
    }
//    val map = hashMapOf<String, Int>()
//
//    fun longestPalindromeSubseq(s: String): Int {
//        if (s in map) {
//            return map[s]!!
//        }
//
//        if (s.length <= 1) {
//            map[s] = s.length
//            return s.length
//        }
//
//        val c = s[0]
//        var max = 0
//        val last = s.lastIndexOf(c)
//        if (last > 0) {
//            max = maxOf(max, 2 + longestPalindromeSubseq(s.substring(1, last)))
//        }
//        max = maxOf(max, longestPalindromeSubseq(s.substring(1)))
//
//        map[s] = max
//        return max
//    }
}