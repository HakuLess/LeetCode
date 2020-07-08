package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

// tag: segmentTree
fun main(args: Array<String>) {
    val s = RangeModule()
//    s.addRange(10, 20)
//    s.removeRange(14, 16)
//    s.queryRange(10, 14).print()
//    s.queryRange(13, 15).print()
//    s.queryRange(16, 17).print()

//    s.addRange(6, 8)
//    s.removeRange(7, 8)
//    s.removeRange(8, 9)
//    s.addRange(8, 9)
//    s.removeRange(1, 3)
//    s.addRange(1, 8)
//    s.queryRange(2, 4).print()
//    s.queryRange(2, 9).print()
//    s.queryRange(4, 6).print()

    s.removeRange(4, 8)
    s.addRange(1, 10)
    s.queryRange(1, 7).print()
//    ["RangeModule","removeRange","addRange","queryRange","addRange","removeRange","queryRange","queryRange","addRange","removeRange"]
//    [[],[4,8],[1,10],[1,7],[2,3],[2,3],[8,9],[6,9],[2,3],[1,8]]
}

class RangeModule() {

    val max = 1000000010
    val root = SegmentTree<Boolean>(start = 0, end = max, value = false) { a, b ->
        a && b
    }

    fun addRange(left: Int, right: Int) {
        root.update(root, left, right - 1, true)
        println("update range $left $right")
        root.print { it == true }
    }

    fun queryRange(left: Int, right: Int): Boolean {
        return root.query(root, left, right - 1)
    }

    fun removeRange(left: Int, right: Int) {
        root.update(root, left, right - 1, false)
        println("remove range $left $right")
        root.print { it == true }
    }

}

/**
 * Your RangeModule object will be instantiated and called as such:
 * var obj = RangeModule()
 * obj.addRange(left,right)
 * var param_2 = obj.queryRange(left,right)
 * obj.removeRange(left,right)
 */