package leetcode.normal

import leetcode.contest.utils.SegmentTree

// todo not finished
// tag: segmentTree
class RangeModule() {

    val root = SegmentTree<Boolean> { a, b ->
        a && b
    }.build(Array<Boolean>(1000000000) { false })!!

    fun addRange(left: Int, right: Int) {
        for (i in left until right) {
            root.update(root, i, true)
        }
    }

    fun queryRange(left: Int, right: Int): Boolean {
        return root.query(root, left, right - 1)
    }

    fun removeRange(left: Int, right: Int) {
        for (i in left until right) {
            root.update(root, i, false)
        }
    }

}

/**
 * Your RangeModule object will be instantiated and called as such:
 * var obj = RangeModule()
 * obj.addRange(left,right)
 * var param_2 = obj.queryRange(left,right)
 * obj.removeRange(left,right)
 */