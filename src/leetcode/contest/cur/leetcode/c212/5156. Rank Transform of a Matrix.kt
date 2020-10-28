package leetcode.contest.cur.leetcode.c212

import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

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
        val tm = TreeMap<Int, ArrayList<Pair<Int, Int>>>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (tm[matrix[i][j]] == null) {
                    tm[matrix[i][j]] = arrayListOf()
                }
                tm[matrix[i][j]]!!.add(Pair(i, j))
            }
        }
        val row = IntArray(n) { Int.MIN_VALUE }
        val col = IntArray(n) { Int.MIN_VALUE }

        val rowId = IntArray(n) { 0 }
        val colId = IntArray(n) { 0 }

        val ans = Array<IntArray>(n) { IntArray(m) { Int.MIN_VALUE } }
        tm.forEach { (i, list) ->
            var changed = true
            while (changed) {
                changed = false
                list.forEach {
                    rowId[it.first] = maxOf(
                            if (row[it.first] == i) rowId[it.first] else rowId[it.first] + 1,
                            if (col[it.second] == i) colId[it.second] else colId[it.second] + 1)
                    colId[it.second] = rowId[it.first]
                    val max = maxOf(rowId[it.first], colId[it.second])
                    if (ans[it.first][it.second] != max) {
                        ans[it.first][it.second] = max
                        changed = true
                    }
                    row[it.first] = i
                    col[it.second] = i
                }
            }
        }
        return ans
    }
//    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
//        val n = matrix.size
//        val m = matrix[0].size
//        val tm = TreeMap<Int, ArrayList<Pair<Int, Int>>>()
//        for (i in matrix.indices) {
//            for (j in matrix[0].indices) {
//                if (tm[matrix[i][j]] == null) {
//                    tm[matrix[i][j]] = arrayListOf()
//                }
//                tm[matrix[i][j]]!!.add(Pair(i, j))
//            }
//        }
//
//        val rowId = IntArray(n) { 0 }
//        val colId = IntArray(n) { 0 }
//
//        val ans = Array<IntArray>(n) { IntArray(m) { Int.MIN_VALUE } }
//        tm.forEach { (i, list) ->
//            val ufs = TypedUFS<Pair<Int, Int>>(list.size)
//            // Union
//            for (i in list.indices) {
//                for (j in i + 1 until list.size) {
//                    if ((list[i].first == list[j].first || list[i].second == list[j].second)
//                            && ufs.typedFind(list[i]) != ufs.typedFind(list[j])) {
//                        ufs.union(list[i], list[j])
//                    }
//                }
//            }
//
//            // Group
//            val group = HashMap<Int, ArrayList<Pair<Int, Int>>>()
//            for (item in list) {
//                val key = ufs.typedFind(item)
//                if (key !in group.keys) {
//                    group[key] = arrayListOf()
//                }
//                group[key]!!.add(item)
//            }
//
//            group.forEach { (_, arrayList) ->
//                var max = 1
//                arrayList.forEach {
//                    max = maxOf(max, maxOf(rowId[it.first] + 1, colId[it.second] + 1))
//                }
//                arrayList.forEach {
//                    rowId[it.first] = max
//                    colId[it.second] = max
//                    ans[it.first][it.second] = max
////                    println("$i: set $it with $max")
////                    rowId.print()
////                    colId.print()
//                }
//            }
//        }
//        return ans
//    }
}