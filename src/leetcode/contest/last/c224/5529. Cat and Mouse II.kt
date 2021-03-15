package leetcode.contest.last.c224

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5529()
//    s.canMouseWin(arrayOf("####F", "#C...", "M...."), 1, 2).print()
//    s.canMouseWin(arrayOf("M.C...F"), 1, 4).print()
//    s.canMouseWin(arrayOf("M.C...F"), 1, 3).print()
//    s.canMouseWin(arrayOf("C...#", "...#F", "....#", "M...."), 2, 5).print()
//    s.canMouseWin(arrayOf("F...", "M#..", "....", ".C.."), 2, 4).print()

    s.canMouseWin(arrayOf("####F", "#C...", "M...."), 1, 2).print()
}

class Solution5529 {
    fun canMouseWin(grid: Array<String>, catJump: Int, mouseJump: Int): Boolean {
        var cx = 0
        var cy = 0
        var mx = 0
        var my = 0
        var fx = 0
        var fy = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                when {
                    grid[i][j] == 'C' -> {
                        cx = i
                        cy = j
                    }
                    grid[i][j] == 'M' -> {
                        mx = i
                        my = j
                    }
                    grid[i][j] == 'F' -> {
                        fx = i
                        fy = j
                    }
                }
            }
        }

        val dr = intArrayOf(0, 1, 0, -1)
        val dc = intArrayOf(1, 0, -1, 0)

        val dp = Array<Array<Array<Array<Array<Boolean?>>>>>(8) {
            Array(8) { Array(8) { Array(8) { Array<Boolean?>(102) { null } } } }
        }

        fun dfs(cx: Int, cy: Int, mx: Int, my: Int, step: Int): Boolean {
            if (dp[cx][cy][mx][my][step] != null) {
                return dp[cx][cy][mx][my][step]!!
            }
            if (step > 100) return false
            if (cx == mx && cy == my) return false
            if (cx == fx && cy == fy) return false
            if (mx == fx && my == fy) return true

            if (step % 2 == 0) {
                // mouse move
                var res = false
                for (i in 0 until 4) {
                    for (j in 0..mouseJump) {
                        val nx: Int = mx + dr[i] * j
                        val ny: Int = my + dc[i] * j
                        if (nx !in grid.indices || ny !in grid[0].indices || grid[nx][ny] == '#') {
                            break
                        }
                        if (nx != mx || ny != my) {
                            if (dfs(cx, cy, nx, ny, step + 1)) {
                                return true.also {
                                    dp[cx][cy][mx][my][step] = it
                                }
                            }
                        }
                    }
                }
                return false.also {
                    dp[cx][cy][mx][my][step] = it
                }
            } else {
                // cat move
                for (i in 0 until 4) {
                    for (j in 0..catJump) {
                        val nx: Int = cx + dr[i] * j
                        val ny: Int = cy + dc[i] * j
                        if (nx !in grid.indices || ny !in grid[0].indices || grid[nx][ny] == '#') {
                            break
                        }
                        if (!dfs(nx, ny, mx, my, step + 1)) {
                            return false.also {
                                dp[cx][cy][mx][my][step] = it
                            }
                        }
                    }
                }
                return true.also {
                    dp[cx][cy][mx][my][step] = it
                }
            }
        }
        return dfs(cx, cy, mx, my, 0)
    }
}