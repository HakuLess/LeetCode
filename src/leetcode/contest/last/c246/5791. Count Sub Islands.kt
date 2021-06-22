package leetcode.contest.last.c246

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5791()
    s.countSubIslands(
        "[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]".toGrid(),
        "[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]".toGrid()
    ).print()
}

class Solution5791 {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        // 方向
        val ori = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )

        fun bfs(i: Int, j: Int): ArrayList<IntArray> {
            val queue: Queue<IntArray> = LinkedList<IntArray>()
            queue.add(intArrayOf(i, j))
            grid2[i][j] = 2
            val ans = ArrayList<IntArray>()
            while (queue.isNotEmpty()) {
                val size = queue.size
                for (k in 0 until size) {
                    val item = queue.poll()
                    ans.add(item)
                    for (o in ori) {
                        val ni = item[0] + o[0]
                        val nj = item[1] + o[1]
                        if (ni in grid2.indices && nj in grid2[0].indices && grid2[ni][nj] == 1) {
                            grid2[ni][nj] = 2
                            queue.offer(intArrayOf(ni, nj))
                        }
                    }
                }
            }
            return ans
        }

        var ans = 0
        for (i in grid2.indices) {
            for (j in grid2[0].indices) {
                if (grid2[i][j] == 1) {
                    val land = bfs(i, j)
                    if (land.all { grid1[it[0]][it[1]] == 1 })
                        ans++
                }
            }
        }
        return ans
    }
}