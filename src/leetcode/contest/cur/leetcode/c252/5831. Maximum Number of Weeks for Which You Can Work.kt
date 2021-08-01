package leetcode.contest.cur.leetcode.c252

class Solution5831 {
    fun numberOfWeeks(milestones: IntArray): Long {
        var sum = 0L
        var max = 0L
        milestones.forEach {
            sum += it
            max = maxOf(max, it.toLong())
        }
        return if (sum - max >= max) {
            sum
        } else {
            (sum - max) * 2 + 1
        }
    }
}