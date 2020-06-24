package leetcode.normal

import leetcode.contest.utils.SegmentTree

class NumArray307(nums: IntArray) {

    private val segmentTree = if (nums.isNotEmpty()) SegmentTree<Int>(nums.toTypedArray()) { a, b -> a + b } else null

    fun update(i: Int, `val`: Int) {
        segmentTree?.update(i, value = `val`)
    }

    fun sumRange(i: Int, j: Int): Int {
        return segmentTree?.query(i, j) ?: 0
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(i,`val`)
 * var param_2 = obj.sumRange(i,j)
 */