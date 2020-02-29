package leetcode.contest.last.c166

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5282()
    s.minFlips(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1))).print()
    s.minFlips(arrayOf(intArrayOf(0))).print()
    s.minFlips(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(0, 0, 0))).print()
    s.minFlips(arrayOf(intArrayOf(1, 0, 0), intArrayOf(1, 0, 0))).print()
}

class Solution5282 {
    val seen = HashSet<String>()
    var m = 0
    var n = 0

    fun minFlips(mat: Array<IntArray>): Int {
        m = mat.size
        n = mat[0].size
        val arrayList = ArrayList<Int>()
        mat.forEach {
            arrayList.addAll(it.toList())
        }
        val queue: Queue<IntArray> = LinkedList<IntArray>()
        queue.add(arrayList.toIntArray())

        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            if (step > 50) {
                return -1
            }
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.all { it == 0 }) {
                    return step
                }
                if (item.joinToString(",") in seen) {
                    continue
                } else {
                    seen.add(item.joinToString(","))
                }
                for (a in 0..mat.lastIndex) {
                    for (b in 0..mat[0].lastIndex) {
                        queue.offer(getNext(item, a, b))
                    }
                }
            }
        }
        return -1
    }

    private fun getNext(cur: IntArray, a: Int, b: Int): IntArray {
        val matrix = Array<IntArray>(m) { IntArray(n) }
        var index = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                matrix[i][j] = cur[index]
                index++
            }
        }

        matrix[a][b] = 1 - matrix[a][b]
        if (isValid(matrix, a - 1, b)) matrix[a - 1][b] = 1 - matrix[a - 1][b]
        if (isValid(matrix, a + 1, b)) matrix[a + 1][b] = 1 - matrix[a + 1][b]
        if (isValid(matrix, a, b - 1)) matrix[a][b - 1] = 1 - matrix[a][b - 1]
        if (isValid(matrix, a, b + 1)) matrix[a][b + 1] = 1 - matrix[a][b + 1]

        val arrayList = ArrayList<Int>()
        matrix.forEach {
            arrayList.addAll(it.toList())
        }
        return arrayList.toIntArray()
    }

    private fun isValid(matrix: Array<IntArray>, a: Int, b: Int): Boolean {
        return a in matrix.indices && b in matrix[0].indices
    }
}