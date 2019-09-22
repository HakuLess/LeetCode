package leetcode.contest.cur.b09

import leetcode.contest.utils.print
import kotlin.math.min

fun main(args: Array<String>) {
    val s = Solution5071()
    s.smallestCommonElement(arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 4, 5, 8, 10),
            intArrayOf(3, 5, 7, 9, 11),
            intArrayOf(1, 3, 5, 7, 9)
    )).print()
}

class Solution5071 {
    fun smallestCommonElement(mat: Array<IntArray>): Int {
        var ans = mat[0].toSet()
        for (i in 1 until mat.size) {
            ans = ans.intersect(mat[i].toSet())
//            ans = filter(ans, mat[i])
            if (ans.isEmpty()) {
                return -1
            }
        }
        return ans.min()!!
    }

    private fun filter(a: IntArray, b: IntArray): IntArray {
        val res = arrayListOf<Int>()
        var i = 0
        var j = 0
        while (i < a.size && j < b.size) {
            when {
                a[i] == b[j] -> {
                    res.add(a[i])
                    i++
                    j++
                }
                a[i] > b[j] -> j++
                else -> i++
            }
        }
        return res.toIntArray()
    }
}