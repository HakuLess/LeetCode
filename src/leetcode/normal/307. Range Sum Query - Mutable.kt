package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = NumArray307(intArrayOf(9, -8))
    s.update(0, 3)
    s.sumRange(1, 1).print()
//    ["NumArray", "update", "sumRange", "sumRange", "update", "sumRange"]
//    [[[9, -8]], [0, 3], [1, 1], [0, 1], [1, -3], [0, 1]]
//    val s = NumArray307(intArrayOf(1, 3, 5))
//    s.sumRange(0, 2).print()
//    s.update(1, 2)
//    s.sumRange(0, 2).print()
}

class NumArray307(nums: IntArray) {

    private val root = SegmentTree { a: Int, b: Int ->
        a + b
    }.build(nums.toTypedArray())

    fun update(i: Int, `val`: Int) {
        root?.update(root, i, value = `val`)
        root.print()
    }

    fun sumRange(i: Int, j: Int): Int {
        return root?.query(root, i, j) ?: 0
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(i,`val`)
 * var param_2 = obj.sumRange(i,j)
 */