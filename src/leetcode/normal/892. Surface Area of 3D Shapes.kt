package leetcode.normal

class Solution892 {
    fun surfaceArea(grid: Array<IntArray>): Int {
        val dr = intArrayOf(0, 1, 0, -1)
        val dc = intArrayOf(1, 0, -1, 0)
        val n = grid.size
        var ans = 0
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (grid[r][c] > 0) {
                    ans += 2
                    for (k in 0..3) {
                        val nr = r + dr[k]
                        val nc = c + dc[k]
                        var nv = 0
                        if (nr in 0 until n && nc in 0 until n) {
                            nv = grid[nr][nc]
                        }
                        ans += maxOf(grid[r][c] - nv, 0)
                    }
                }
            }
        }
        return ans
    }
}