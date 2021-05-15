package leetcode.contest.cur.leetcode.b52

class Solution5742 {
    fun sortSentence(s: String): String {
        return s.split(" ").sortedBy { it.last() }.map {
            it.take(it.length - 1)
        }.joinToString(" ")
    }
}