package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
    s.sumRange(0, 2).print()
    s.sumRange(2, 5).print()
    s.sumRange(0, 5).print()
}

class NumArray(var nums: IntArray) {

//    private val segmentTree = if (nums.isNotEmpty()) SegmentTree<Int>(nums.toTypedArray()) { a, b -> a + b } else null

    fun sumRange(i: Int, j: Int): Int {
//        return segmentTree?.query(i, j) ?: 0
        return 0
    }
}

//class NumArray(var nums: IntArray) {
//
//    private var sum: IntArray = IntArray(nums.size + 1)
//
//    init {
//        for (i in nums.indices) {
//            sum[i + 1] = sum[i] + nums[i]
//        }
//    }
//
//    fun sumRange(i: Int, j: Int): Int {
//        return sum[j + 1] - sum[i]
//    }
//}