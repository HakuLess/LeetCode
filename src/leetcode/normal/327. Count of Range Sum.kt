package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution327()
    s.countRangeSum(intArrayOf(-2, 5, -1), -2, 2).print()
}

// todo not finished
class Solution327 {
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val root = SegmentTree<Int>(start = 0, end = nums.size, value = 0) { a, b ->
            a + b
        }
        var ans = 0
        for (i in nums.indices) {
            root.update(root, 0, i, nums[i])
            ans += root.query(root, 0, nums.size)
        }
        return ans
    }
}