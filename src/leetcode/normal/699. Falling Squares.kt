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

    s.fallingSquares(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(6, 1)
    )).toIntArray().print()
//
    s.fallingSquares(arrayOf(
            intArrayOf(100, 100),
            intArrayOf(200, 100)
    )).toIntArray().print()
}

class Solution699 {
    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        val max = 100000010
        val root = SegmentTree<Int>(start = 0, end = max, value = 0) { a, b -> maxOf(a, b) }
        val ans = arrayListOf<Int>()
        positions.forEach {
            val cur = root.query(root, it[0], it[0] + it[1] - 1) + it[1]
            println("update left ${it[0]} right ${it[0] + it[1]}, $cur")
            root.update(root, it[0], it[0] + it[1] - 1, cur)
            ans.add(root.query(root, 0, max))
        }
        return ans
    }

//    fun fallingSquares(positions: Array<IntArray>): List<Int> {
//        val pos = ArrayList<Int>()
//        positions.forEach {
//            pos.add(it[0])
//            pos.add(it[0] + it[1] - 1)
//        }
//        pos.sort()
//        val map = HashMap<Int, Int>()
//        var index = 0
//        pos.forEach {
//            if (!map.containsKey(it))
//                map[it] = index++
//        }
//        val root = SegmentTree<Int> { a: Int, b: Int ->
//            maxOf(a, b)
//        }.build(IntArray(2020).toTypedArray())
//
//        val ans = arrayListOf<Int>()
//        positions.forEach {
//            val cur = root!!.query(root, map[it[0]]!!, map[it[0] + it[1] - 1]!!) + it[1]
//            println("update left ${it[0]} right ${it[0] + it[1]}, $cur")
//            root.update(root, map[it[0]]!!, map[it[0] + it[1] - 1]!!, cur)
//            ans.add(root.query(root, 0, 2020))
//        }
//        return ans
//    }
}