package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution699()

    s.fallingSquares(arrayOf(
            intArrayOf(6, 1),
            intArrayOf(9, 2),
            intArrayOf(2, 4)
    )).toIntArray().print()

//    s.fallingSquares(arrayOf(
//            intArrayOf(1, 2),
//            intArrayOf(2, 3),
//            intArrayOf(6, 1)
//    )).toIntArray().print()
//
//    s.fallingSquares(arrayOf(
//            intArrayOf(100, 100),
//            intArrayOf(200, 100)
//    )).toIntArray().print()
}

// todo Not Finished
class Solution699 {
    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        val root = SegmentTree<Int> { a: Int, b: Int ->
            maxOf(a, b)
        }.build(IntArray(1010).toTypedArray())

        val ans = arrayListOf<Int>()
        positions.forEach {
            val cur = root!!.query(root, it[0], it[0] + it[1] - 1) + it[1]
            for (i in it[0] until it[0] + it[1]) {
                println("update $i, $cur")
                root.update(root, i, cur)
            }
            ans.add(root.query(root, 0, 1000))
        }
        return ans
    }
}