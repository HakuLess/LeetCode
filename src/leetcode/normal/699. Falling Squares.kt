package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution699()
    s.fallingSquares(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(6, 1)
    )).toIntArray().print()
}

// Not Finished
class Solution699 {
    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        val set = HashSet<Int>()
        positions.forEach {
            set.add(it[0])
            set.add(it[0] + it[1] - 1)
        }
        val index = HashMap<Int, Int>()
        val list = ArrayList<Int>(set)
        list.sort()
        var t = 0
        list.forEach {
            index[it] = t++
        }

        val segmentTree = SegmentTree(Array<Int>(list.size) { 0 }) { a, b ->
            maxOf(a, b)
        }
        val ans = arrayListOf<Int>()
        positions.forEach {
            for (i in it[0] until it[0] + it[1]) {
                segmentTree.update(index[i]!!, segmentTree.get(index[i]!!) + it[1])
                ans.add(segmentTree.query(0, index[i]!!))
            }
        }
        return ans
    }
}