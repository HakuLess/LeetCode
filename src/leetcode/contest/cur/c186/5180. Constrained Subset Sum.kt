package leetcode.contest.cur.c186

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5180()
//    s.constrainedSubsetSum(intArrayOf(10, 2, -10, 5, 20), 2).print()
//    s.constrainedSubsetSum(intArrayOf(-2, 3, 1), 2).print()
//    s.constrainedSubsetSum(intArrayOf(-1, -2, -3), 2).print()
    s.constrainedSubsetSum(intArrayOf(10, -2, -10, -5, 20), 2).print()

}

class Solution5180 {

    var n = intArrayOf()
    val seen = HashMap<Int, Int>()
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        n = nums
        helper(0, k)
        if (nums.all { it <= 0 }) {
            return nums.max()!!
        }
        return seen.maxBy { it.value }!!.value
    }

    private fun helper(cur: Int, k: Int): Int {
        if (cur in seen) {
            return seen[cur]!!
        }
        if (cur !in n.indices) {
            return 0
        }
        var ans = 0
        for (i in 1..k) {
            ans = maxOf(ans, helper(cur + i, k) + n[cur])
        }
        seen[cur] = ans
        return ans
    }
}