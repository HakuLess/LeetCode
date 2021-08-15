package leetcode.contest.cur.leetcode.c254

class Solution5843 {
    fun numOfStrings(patterns: Array<String>, word: String): Int {
        return patterns.count { it in word }
    }
}