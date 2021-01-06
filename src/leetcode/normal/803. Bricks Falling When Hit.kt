package leetcode.normal

import leetcode.contest.utils.TypedUFS

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution803()
//    s.hitBricks("[[1,0,0,0],[1,1,1,0]]".toGrid(), "[[1,0]]".toGrid()).print()
//    s.hitBricks("[[1,0,0,0],[1,1,0,0]]".toGrid(), "[[1,1],[1,0]]".toGrid()).print()
//    s.hitBricks("[[1],[1],[1],[1],[1]]".toGrid(), "[[3,0],[4,0],[1,0],[2,0],[0,0]]".toGrid()).print()
    s.hitBricks("[[0,1,1,1,1,1],[1,1,1,1,1,1],[0,0,1,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,0]]".toGrid(),
            "[1,1]".toGrid()).print()

}

class Solution803 {
    fun hitBricks(grid: Array<IntArray>, hits: Array<IntArray>): IntArray {

        val R: Int = grid.size
        val C: Int = grid[0].size
        val dr = intArrayOf(1, 0, -1, 0)
        val dc = intArrayOf(0, 1, 0, -1)

        val A = Array(R) { IntArray(C) }
        for (r in 0 until R) A[r] = grid[r].clone()
        for (hit in hits) A[hit[0]][hit[1]] = 0

        val ufs = TypedUFS<Int>(R * C + 1)
        for (r in 0 until R) {
            for (c in 0 until C) {
                if (A[r][c] == 1) {
                    val i = r * C + c
                    if (r == 0) ufs.union(i, R * C)
                    if (r > 0 && A[r - 1][c] == 1) ufs.union(i, (r - 1) * C + c)
                    if (c > 0 && A[r][c - 1] == 1) ufs.union(i, r * C + c - 1)
                }
            }
        }

        val ans = arrayListOf<Int>()
        hits.reversed().forEach {
            if (grid[it[0]][it[1]] == 1) {
                val last = ufs.count[ufs.typedFind(R * C)]
                for (i in 0..3) {
                    val x = it[0] + dr[i]
                    val y = it[1] + dc[i]
                    if (x in A.indices && y in A[0].indices && A[x][y] == 1) {
                        ufs.union(it[0] * C + it[1], x * C + y)
                    }
                    if (it[0] == 0) {
                        ufs.union(it[0] * C + it[1], R * C)
                    }
                }
                A[it[0]][it[1]] = 1
                val now = ufs.count[ufs.typedFind(R * C)]
                ans.add(maxOf(now - last - 1, 0))
            } else {
                ans.add(0)
            }
        }
        return ans.reversed().toIntArray()
    }
}