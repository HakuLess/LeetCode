package leetcode.contest.cur.leetcode.c219

class Solution5626 {
    fun minPartitions(n: String): Int {
        return n.map { Integer.parseInt(it.toString()) }.max()!!
    }
}