package leetcode.normal

class Solution905 {
    fun sortArrayByParity(nums: IntArray): IntArray {
        return nums.filter { it % 2 == 0 }.toIntArray() + nums.filter { it % 2 != 0 }
    }
}
