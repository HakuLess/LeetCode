package leetcode.normal

class Solution561 {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var sum = 0
        nums.forEachIndexed { index, i ->
            if (index % 2 == 0) {
                sum += i
            }
        }
        return sum
    }
}