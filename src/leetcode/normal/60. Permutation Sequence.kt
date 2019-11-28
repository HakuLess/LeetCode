package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution60()
    s.getPermutation(3, 3).print()
    s.getPermutation(4, 9).print()
}

class Solution60 {
    fun getPermutation(n: Int, k: Int): String {
        val nums = IntArray(n) { i -> i + 1 }
        var step = 1
        while (step != k) {
            nextPermutation(nums)
            step++
        }
        return nums.joinToString("")
    }

    private fun nextPermutation(nums: IntArray) {
        for (i in nums.size - 2 downTo 0) {
            for (j in nums.size - 1 downTo i + 1) {
                if (nums[j] > nums[i]) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                    nums.sort(i + 1, nums.size)
                    return
                }
            }
        }
        nums.reverse()
    }
}