package leetcode.contest.cur.leetcode.c231

class Solution5697 {
    fun checkOnesSegment(s: String): Boolean {
        val l = s.indexOfFirst { it == '1' }
        val r = s.indexOfLast { it == '1' }
        return (l..r).all { s[it] == '1' }
    }

//    fun checkOnesSegment(s: String): Boolean {
//        return s.split('0').filter { it.isNotEmpty() }.size <= 1
//    }
}