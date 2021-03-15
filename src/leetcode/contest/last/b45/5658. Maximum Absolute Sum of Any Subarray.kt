package leetcode.contest.last.b45

class Solution5658 {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var max = 0
        var preMax = 0
        var min = 0
        var preMin = 0
        for (num in nums) {
            preMax = maxOf(preMax + num, 0)
            max = maxOf(max, preMax)
            preMin = minOf(preMin + num, 0)
            min = minOf(min, preMin)
        }
        return maxOf(max, -min)
    }
}