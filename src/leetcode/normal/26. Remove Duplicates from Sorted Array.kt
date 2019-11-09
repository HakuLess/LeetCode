package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution26()
//    val intArray = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val intArray = intArrayOf(1, 1, 2)
    s.removeDuplicates(intArray).print()
    intArray.print()
}

class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var j = 0
        for (i in nums.indices) {
            if (nums[j] != nums[i]) nums[++j] = nums[i]
        }
        return j + 1
    }
//    fun removeDuplicates(nums: IntArray): Int {
//        if (nums.isEmpty()) {
//            return 0
//        }
//        var cur = Pair(0, nums[0])
//        for (i in 1..nums.lastIndex) {
//            if (nums[i] != cur.second) {
//                cur = Pair(cur.first + 1, nums[i])
//                nums[cur.first] = cur.second
//            }
//        }
//        return cur.first + 1
//    }
}