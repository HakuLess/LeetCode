package leetcode.contest.last.c225

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5663()
    s.kthLargestValue("[[5,2],[1,6]]".toGrid(), 1).print()
    s.kthLargestValue("[[5,2],[1,6]]".toGrid(), 2).print()
}

class Solution5663 {
    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.size
        val m: Int = matrix[0].size
        val xor = Array(n) { IntArray(m) }
        val pq = PriorityQueue<Int>()
        for (i in 0 until n) {
            for (j in 0 until m) {
                val a = if (i - 1 >= 0) xor[i - 1][j] else 0
                val b = if (j - 1 >= 0) xor[i][j - 1] else 0
                val c = if (i - 1 >= 0 && j - 1 >= 0) xor[i - 1][j - 1] else 0
                xor[i][j] = matrix[i][j] xor a xor b xor c
                pq.add(xor[i][j])
                if (pq.size > k) {
                    pq.poll()
                }
            }
        }
        return pq.poll()
    }
}

