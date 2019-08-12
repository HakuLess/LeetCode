package leetcode.contest.last.b06

class Solution1150 {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {
        val t = nums.count {
            it == target
        }
        return t > nums.size / 2
    }
}