package leetcode.contest.cur.leetcode.c196

class Solution5453 {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        var max = 0
        left.forEach {
            max = maxOf(max, it)
        }
        right.forEach {
            max = maxOf(max, n - it)
        }
        return max
    }
}