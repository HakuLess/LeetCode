package leetcode.contest.last.c181

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5366()
    s.hasValidPath(arrayOf(
            intArrayOf(2, 4, 3),
            intArrayOf(6, 5, 2)
    )).print()

//    s.hasValidPath(arrayOf(
//            intArrayOf(1, 1, 2)
//    )).print()
}

class Solution5366 {

    var ans = false
    val seen = HashSet<String>()
    fun hasValidPath(grid: Array<IntArray>): Boolean {
        dfs(intArrayOf(0, 0), grid, -1)
        return ans
    }

    private fun dfs(cur: IntArray, grid: Array<IntArray>, from: Int) {
        println("${cur[0]} ${cur[1]}  $from")
        if (cur.joinToString(",") in seen) {
            return
        }
        seen.add(cur.joinToString(","))
        if (cur[0] !in grid.indices || cur[1] !in grid[0].indices) {
            return
        }

        when (grid[cur[0]][cur[1]]) {
            1 -> {
                if (from == -1 || from == 1 || from == 2) {
                    if (cur[0] == grid.lastIndex && cur[1] == grid[0].lastIndex) {
                        ans = true
                        return
                    }
                    dfs(intArrayOf(cur[0], cur[1] + 1), grid, 1)
                    dfs(intArrayOf(cur[0], cur[1] - 1), grid, 2)
                }
            }
            2 -> {
                if (from == -1 || from == 3 || from == 4) {
                    if (cur[0] == grid.lastIndex && cur[1] == grid[0].lastIndex) {
                        ans = true
                        return
                    }
                    dfs(intArrayOf(cur[0] - 1, cur[1]), grid, 3)
                    dfs(intArrayOf(cur[0] + 1, cur[1]), grid, 4)
                }
            }
            3 -> {
                if (from == -1 || from == 1 || from == 3) {
                    if (cur[0] == grid.lastIndex && cur[1] == grid[0].lastIndex) {
                        ans = true
                        return
                    }
                    dfs(intArrayOf(cur[0], cur[1] - 1), grid, 2)
                    dfs(intArrayOf(cur[0] + 1, cur[1]), grid, 4)
                }
            }
            4 -> {
                if (from == -1 || from == 2 || from == 3) {
                    if (cur[0] == grid.lastIndex && cur[1] == grid[0].lastIndex) {
                        ans = true
                        return
                    }
                    dfs(intArrayOf(cur[0], cur[1] + 1), grid, 1)
                    dfs(intArrayOf(cur[0] + 1, cur[1]), grid, 4)
                }
            }
            5 -> {
                if (from == -1 || from == 4 || from == 1) {
                    if (cur[0] == grid.lastIndex && cur[1] == grid[0].lastIndex) {
                        ans = true
                        return
                    }
                    dfs(intArrayOf(cur[0], cur[1] - 1), grid, 2)
                    dfs(intArrayOf(cur[0] - 1, cur[1]), grid, 3)
                }
            }
            6 -> {
                if (from == -1 || from == 4 || from == 2) {
                    if (cur[0] == grid.lastIndex && cur[1] == grid[0].lastIndex) {
                        ans = true
                        return
                    }
                    dfs(intArrayOf(cur[0], cur[1] + 1), grid, 1)
                    dfs(intArrayOf(cur[0] - 1, cur[1]), grid, 3)
                }
            }
        }
    }
}