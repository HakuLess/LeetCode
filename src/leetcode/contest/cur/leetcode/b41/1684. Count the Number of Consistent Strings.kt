package leetcode.contest.cur.leetcode.b41

class Solution1684 {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        return words.count { it.all { it in allowed } }
    }
}