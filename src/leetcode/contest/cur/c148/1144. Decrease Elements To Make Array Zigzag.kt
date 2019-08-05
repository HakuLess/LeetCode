package leetcode.contest.cur.c148

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1144()
    s.movesToMakeZigzag(intArrayOf(9, 6, 1, 6, 2)).print()
    s.movesToMakeZigzag(intArrayOf(1, 2, 3)).print()
    s.movesToMakeZigzag(intArrayOf(2, 7, 10, 9, 8, 9)).print()
    s.movesToMakeZigzag(intArrayOf(10, 4, 4, 10, 10, 6, 2, 3)).print()
}

class Solution1144 {
    fun movesToMakeZigzag(nums: IntArray): Int {
        return minOf(getMin(nums.clone(), true), getMin(nums.clone(), false))
    }

    private fun getMin(nums: IntArray, b: Boolean): Int {
        var ans = 0
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1] && if (b) {
                        i % 2 == 0
                    } else {
                        i % 2 != 0
                    }) {
                ans += nums[i - 1] - nums[i] + 1
                nums[i - 1] = nums[i] - 1
            }
            if (nums[i] >= nums[i - 1] && if (b) {
                        i % 2 != 0
                    } else {
                        i % 2 == 0
                    }) {
                ans += nums[i] - nums[i - 1] + 1
                nums[i] = nums[i - 1] - 1
            }
        }
//        nums.print()
//        println(ans)
        return ans
    }
}