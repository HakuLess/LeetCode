package leetcode.contest.cur.c167

import leetcode.contest.utils.print
import leetcode.learn.TNode
import leetcode.learn.diffCount
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5285()
//    s.maxSideLength(
//            arrayOf(
//                    intArrayOf(1, 1, 3, 2, 4, 3, 2),
//                    intArrayOf(1, 1, 3, 2, 4, 3, 2),
//                    intArrayOf(1, 1, 3, 2, 4, 3, 2)
//            ), 4
//    ).print()

//    [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]]
//    40184
//    s.maxSideLength(
//            arrayOf(
//                    intArrayOf(18,70),
//                    intArrayOf(61,1),
//                    intArrayOf(25,85),
//                    intArrayOf(14,40),
//                    intArrayOf(11,96),
//                    intArrayOf(97,96),
//                    intArrayOf(63,45)
//
//            ), 40184
//    ).print()

    s.maxSideLength(
            arrayOf(
                    intArrayOf(18,70),
                    intArrayOf(61,10),
                    intArrayOf(25,85),
                    intArrayOf(14,40),
                    intArrayOf(11,96),
                    intArrayOf(97,96),
                    intArrayOf(63,45)

            ), 1
    ).print()
}

class Solution5285 {
    var ans = -1
    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {

        for (i in mat.indices) {
            for (j in mat[0].indices) {
                check(mat, i, j, threshold)
            }
        }
        return if (ans == -1) {
            minOf(mat.size, mat[0].size)
        } else {
            ans
        }
    }

    private fun check(mat: Array<IntArray>, x: Int, y: Int, threshold: Int) {
        var cur = 0
        for (i in 0..10000) {
            for (j in y..y + i) {
//                println("$i: ${x + i}, $j")
                if (x + i > mat.lastIndex || j > mat[0].lastIndex) {
                    return
                }
                cur += mat[x + i][j]
            }
            for (j in x..x + i) {
//                println("$i: ${j}, ${y + i}")
                if (j > mat.lastIndex || y + i > mat[0].lastIndex) {
                    return
                }
                cur += mat[j][y + i]
            }
            cur -= mat[x + i][y + i]
//            println("$x, $y, $i, $cur")
            if (cur > threshold) {
                ans = maxOf(ans, i)
                return
            }
        }
    }
}