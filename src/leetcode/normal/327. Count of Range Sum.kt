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
        val root = SegmentTree<Long> { a, b ->
            a + b
        }.build(nums.map { it.toLong() }.toTypedArray())
        var ans = 0
        for (i in nums.indices) {
            for (j in i..nums.lastIndex) {
                if (root!!.query(root, i, j) in lower..upper) {
                    ans++
                }
            }
        }
        return ans
    }
}