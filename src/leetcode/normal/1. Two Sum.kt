package leetcode.normal

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val calcMap = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, it ->
            val diff = target - it
            if (calcMap.containsKey(diff)) {
                return intArrayOf(calcMap[diff]!!, index)
            }
            calcMap[it] = index
        }
        return nums
    }
}