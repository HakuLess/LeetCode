package leetcode.contest.b03

import leetcode.print
import java.util.*
import kotlin.math.min

fun main(args: Array<String>) {
    val s = Solution1102()
    s.maximumMinimumPath(
            arrayOf(
                    intArrayOf(5, 4, 5),
                    intArrayOf(1, 2, 6),
                    intArrayOf(7, 4, 6)
            )
    ).print()
}

class Solution1102 {
    fun maximumMinimumPath(A: Array<IntArray>): Int {
        val dx = intArrayOf(0, 0, -1, 1)
        val dy = intArrayOf(1, -1, 0, 0)
        val m = A.size
        val n = A[0].size
        val ans = Array(m) { IntArray(n) }
        ans[0][0] = A[0][0]

        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(0, 0))
        while (queue.isNotEmpty()) {
            val item = queue.poll()
            val x = item.first
            val y = item.second
            val cur = ans[x][y]
            for (i in 0 until 4) {
                val xx = x + dx[i]
                val yy = y + dy[i]
                if (xx !in 0 until m || yy !in 0 until n) {
                    continue
                }
                if (ans[xx][yy] < min(cur, A[xx][yy])) {
                    ans[xx][yy] = min(cur, A[xx][yy])
                    queue.offer(Pair(xx, yy))
                }
            }
        }

        return ans[m - 1][n - 1]
    }
}

//class Solution {
//    private val seen = Array(110) { IntArray(110) }
//
//    fun maximumMinimumPath(A: Array<IntArray>): Int {
//        dfs(0, 0, A[0][0], A, 0)
//        return seen[A.lastIndex][A[0].lastIndex]
//    }
//
//    private fun dfs(x: Int, y: Int, pre: Int, A: Array<IntArray>, step: Int) {
//        if (x !in 0 until A.size || y !in 0 until A[0].size) {
//            return
//        }
//        if (seen[x][y] >= min(pre, A[x][y])) {
//            return
//        }
//        seen[x][y] = min(pre, A[x][y])
//
//        if (x == A.lastIndex && y == A[0].lastIndex) {
//            return
//        }
//        dfs(x + 1, y, minOf(A[x][y], pre), A, step + 1)
//        dfs(x - 1, y, minOf(A[x][y], pre), A, step + 1)
//        dfs(x, y + 1, minOf(A[x][y], pre), A, step + 1)
//        dfs(x, y - 1, minOf(A[x][y], pre), A, step + 1)
//    }
//}