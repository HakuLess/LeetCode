package leetcode.contest.cur.leetcode.b54

class Solution5202 {
    fun largestMagicSquare(grid: Array<IntArray>): Int {
        var ans = 0
        val m = grid.size
        val n = grid[0].size
        fun cal(i: Int, j: Int, k: Int) {
            var sum = 0L
            for (x in i..(i + k)) {
                sum += grid[x][j]
            }
            for (x in i..(i + k)) {
                var cmp = 0L
                for (y in j..(j + k)) {
                    cmp += grid[x][y]
                }
                if (cmp != sum) return
            }
            for (y in j..(j + k)) {
                var cmp = 0L
                for (x in i..(i + k)) {
                    cmp += grid[x][y]
                }
                if (cmp != sum) return
            }
            var cmp = 0L
            for (t in 0..k) {
                cmp += grid[i + t][j + t]
            }
            if (cmp != sum) return

            cmp = 0L
            for (t in 0..k) {
                cmp += grid[i + t][j + k - t]
            }
            if (cmp != sum) return
            ans = maxOf(ans, k)
        }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                for (k in 0 until maxOf(n, m)) {
                    if (i + k in grid.indices && j + k in grid[0].indices) {
                        cal(i, j, k)
                    } else break
                }
            }
        }
        return ans + 1
    }
}