package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution45()
    s.jump(intArrayOf(2, 3, 0, 1, 4)).print()
}

class Solution45 {
    fun jump(nums: IntArray): Int {
        var end = 0
        var maxPosition = 0
        var steps = 0
        for (i in 0 until nums.lastIndex) {
            maxPosition = maxOf(maxPosition, nums[i] + i)
            if (i == end) {
                end = maxPosition
                steps++
            }
        }
        return steps
    }

//    fun jump(nums: IntArray): Int {
//        val ans = IntArray(nums.size) { Int.MAX_VALUE / 2 }
//        for (i in nums.lastIndex downTo 0) {
//            if (i == nums.lastIndex) {
//                ans[i] = 0
//            } else {
//                for (step in 1..nums[i]) {
//                    if (i + step < nums.size) {
//                        ans[i] = minOf(ans[i], 1 + ans[i + step])
//                    }
//                }
//            }
//        }
//
//        return ans[0]
//    }
}