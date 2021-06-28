package leetcode.contest.cur.leetcode.c247

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5798()
//    s.rotateGrid("[[40,10],[30,20]]".toGrid(), 1).print()
    s.rotateGrid("[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]".toGrid(), 2).print()
}

// TAG: Matrix 矩阵 按层遍历 Rotate
class Solution5798 {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size
        val max = minOf(n, m) / 2
        val ans = Array<IntArray>(n) { IntArray(m) }
        for (d in 0 until max) {
            val l = arrayListOf<Pair<Int, Int>>()
            var i = d
            var j = d
            // Top
            while (j < m - d - 1) {
                l.add(Pair(i, j))
                j++
            }
            // Right
            while (i < n - d - 1) {
                l.add(Pair(i, j))
                i++
            }
            // Bottom
            while (j > d) {
                l.add(Pair(i, j))
                j--
            }
            // Left
            while (i > d) {
                l.add(Pair(i, j))
                i--
            }
            val rot = Array<Pair<Int, Int>>(l.size) { Pair(0, 0) }
            val mod = k % l.size
            for (i in rot.indices) {
                rot[i] = l[(i + l.size - mod) % l.size]
            }
            for (i in rot.indices) {
                ans[rot[i].first][rot[i].second] = grid[l[i].first][l[i].second]
            }
        }
        return ans
    }
}