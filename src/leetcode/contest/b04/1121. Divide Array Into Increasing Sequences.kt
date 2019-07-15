package leetcode.contest.b04

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1121()
    s.canDivideIntoSubsequences(
            intArrayOf(1, 2, 2, 3, 3, 4, 4),
            3
    ).print()

    s.canDivideIntoSubsequences(
            intArrayOf(5, 6, 6, 7, 8),
            3
    ).print()

    s.canDivideIntoSubsequences(
            intArrayOf(5, 5, 5, 5, 5, 5),
            6
    ).print()

    s.canDivideIntoSubsequences(
            intArrayOf(1, 1, 2, 3, 4, 4),
            3
    ).print()
}

class Solution1121 {

    fun canDivideIntoSubsequences(nums: IntArray, K: Int): Boolean {
        // index & value
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        if (map.values.max()!! * K > nums.size) {
            return false
        }
        return true
    }
}