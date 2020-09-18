package leetcode.normal

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution685()
//    s.findRedundantDirectedConnection(arrayOf(
//            intArrayOf(1, 2),
//            intArrayOf(1, 3),
//            intArrayOf(2, 3)
//    )).print()

    s.findRedundantDirectedConnection(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 1),
            intArrayOf(1, 5)
    )).print()

    s.findRedundantDirectedConnection(arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(4, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 5)
    )).print()
}

class Solution685 {
    fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
        return intArrayOf()
    }
}