package leetcode.contest.cur.leetcode.b42

class Solution1701 {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var cur = 0
        var ans = 0.0
        customers.forEach {
            cur = maxOf(cur, it[0])
            cur += it[1]
            ans += cur - it[0]
        }
        return ans / customers.size
    }
}