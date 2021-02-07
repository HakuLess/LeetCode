package leetcode.contest.cur.leetcode.c227

class Solution5672 {
    fun check(nums: IntArray): Boolean {
        val cur = ArrayList(nums.sorted())
        cur.addAll(cur)
        return nums.joinToString(",") in cur.joinToString(",")
    }
}