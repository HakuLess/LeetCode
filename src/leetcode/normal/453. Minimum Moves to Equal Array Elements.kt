package leetcode.normal

class Solution453 {
    fun minMoves(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val min = nums.minOrNull()!!
        return nums.sumBy { it - min }
    }
}