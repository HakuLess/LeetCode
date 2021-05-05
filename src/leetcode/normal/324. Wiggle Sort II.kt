package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution324()
    val nums = intArrayOf(1, 5, 1, 1, 6, 4)
    s.wiggleSort(nums)
    nums.print()
}

class Solution324 {
    fun wiggleSort(nums: IntArray): Unit {
        val help = nums.clone()
        help.sort()
        var n = nums.size
        var i = 1
        while (i < nums.size) {
            nums[i] = help[--n]
            i += 2
        }
        i = 0
        while (i < nums.size) {
            nums[i] = help[--n]
            i += 2
        }
    }
}