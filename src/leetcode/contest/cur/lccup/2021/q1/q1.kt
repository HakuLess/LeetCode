package leetcode.contest.cur.lccup.`2021`.q1

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solutionq1()
    s.purchasePlans(intArrayOf(1, 2, 2, 9), 10).print()
}

class Solutionq1 {
    fun purchasePlans(nums: IntArray, target: Int): Int {
        nums.sort()
        val mod = 1000000007L
        var i = 0
        var j = nums.lastIndex
        var ans = 0L
        while (i in nums.indices && j in nums.indices && i < j) {
            while (j in nums.indices && nums[i] + nums[j] > target) {
                j--
            }
            if (i >= j) break
            ans += j - i
            ans %= mod
            i++
        }
        return (ans % mod).toInt()
    }
}