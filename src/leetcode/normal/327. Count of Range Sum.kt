package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution327()
    s.countRangeSum(intArrayOf(-2, 5, -1), -2, 2).print()
}

// not finished
class Solution327 {
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val segmentTree = SegmentTree<Long>(nums.map { it.toLong() }.toTypedArray()) { a, b ->
            a + b
        }
        var ans = 0
        for (i in nums.indices) {
            for (j in i..nums.lastIndex) {
                if (segmentTree.query(i, j) in lower..upper) {
                    ans++
                }
            }
        }
        return ans
    }
}