package leetcode.contest.cur.leetcode.c212

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5156()
//    s.matrixRankTransform(arrayOf(
//            intArrayOf(1, 2),
//            intArrayOf(3, 4)
//    )).print()
//
//    s.matrixRankTransform(arrayOf(
//            intArrayOf(7, 7),
//            intArrayOf(7, 7)
//    )).print()

//    s.matrixRankTransform(arrayOf(
//            intArrayOf(20, -21, 14),
//            intArrayOf(-19, 4, 19),
//            intArrayOf(22, -47, 24),
//            intArrayOf(-19, 4, 19)
//    )).print()

    s.matrixRankTransform(arrayOf(
            intArrayOf(-37, -50, -3, 44),
            intArrayOf(-37, 46, 13, -32),
            intArrayOf(47, -42, -3, -40),
            intArrayOf(-17, -22, -39, 24)
    )).print()
}

class Solution5156 {
    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
        val n = matrix.size
        val m = matrix[0].size
        val list = ArrayList<Triple<Int, Int, Int>>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                list.add(Triple(matrix[i][j], i, j))
            }
        }
        list.sortBy { it.first }
        val row = IntArray(n) { Int.MIN_VALUE }
        val col = IntArray(n) { Int.MIN_VALUE }

        val rowId = IntArray(n) { 0 }
        val colId = IntArray(n) { 0 }

        val ans = Array<IntArray>(n) { IntArray(m) { Int.MIN_VALUE } }

        list.forEach {
            println("f ${it.first}")
            row.print()
            col.print()
            println("====")
            rowId[it.second] = maxOf(
                    if (row[it.second] == it.first) rowId[it.second] else rowId[it.second] + 1,
                    if (col[it.third] == it.first) colId[it.third] else colId[it.third] + 1)
            colId[it.third] = rowId[it.second]
            ans[it.second][it.third] = maxOf(rowId[it.second], colId[it.third])
            row[it.second] = it.first
            col[it.third] = it.first
            println("ans is")
            ans.print()
        }

        return ans
    }
}