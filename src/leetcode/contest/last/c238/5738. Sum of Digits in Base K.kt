package leetcode.contest.last.c238

class Solution5738 {
    fun sumBase(n: Int, k: Int): Int {
        return n.toString(k).sumBy { it - '0' }
    }
}