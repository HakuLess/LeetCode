package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution594()
    s.findLHS(intArrayOf(1, 3, 2, 2, 5, 2, 3, 7)).print()
    s.findLHS(intArrayOf(1, 1, 1, 1)).print()
}

class Solution594 {
    fun findLHS(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        for (i in nums.indices) {
            map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
        }
        var max = 0
        map.forEach { (t, u) ->
            if (map.containsKey(t + 1)) {
                max = maxOf(u + map[t + 1]!!, max)
            }
        }
        return max
    }
}