package leetcode.contest.cur.leetcode.c231

class Solution5698 {
    fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
        var sum: Long = 0
        val g = goal.toLong()
        val l = limit.toLong()
        nums.forEach {
            sum += it
        }
        if (sum == g) {
            return 0
        } else if (sum > goal) {
            return ((sum - g) / limit + (if ((sum - g) % l == 0L) 0 else 1)).toInt()
        } else {
            return ((g - sum) / limit + (if ((g - sum) % l == 0L) 0 else 1)).toInt()
        }
    }
}