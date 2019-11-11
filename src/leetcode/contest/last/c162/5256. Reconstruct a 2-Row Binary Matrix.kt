package leetcode.contest.last.c162

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5256()
    s.reconstructMatrix(2, 1, intArrayOf(1, 1, 1)).print()
    s.reconstructMatrix(2, 3, intArrayOf(2, 2, 1, 1)).print()
    s.reconstructMatrix(5, 5, intArrayOf(2, 1, 2, 0, 1, 0, 1, 2, 0, 1)).print()
    s.reconstructMatrix(9, 2, intArrayOf(0, 1, 2, 0, 0, 0, 0, 0, 2, 1, 2, 1, 2)).print()
}

class Solution5256 {
    fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): List<List<Int>> {
        if (upper + lower != colsum.sum() || minOf(upper, lower) < colsum.count { it == 2 }) {
            return emptyList()
        }
        val a = IntArray(colsum.size) { 0 }
        val b = IntArray(colsum.size) { 0 }
        for (it in colsum.indices) {
            if (colsum[it] == 0) {
                a[it] = 0
                b[it] = 0
            } else if (colsum[it] == 2) {
                a[it] = 1
                b[it] = 1
            }
        }

        var sumA = a.sum()
        for (it in a.indices) {
            if (colsum[it] == 1) {
                if (sumA != upper) {
                    a[it] = 1
                    b[it] = 0
                    sumA += 1
                } else {
                    a[it] = 0
                    b[it] = 1
                }
            }
        }
        return listOf(a.toList(), b.toList())
    }
}