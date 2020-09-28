package leetcode.normal

class Solution807 {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }
        val hor = IntArray(grid[0].size)
        val ver = IntArray(grid.size)
        for (i in hor.indices) {
            for (j in ver.indices) {
                ver[j] = grid[j].max()!!
                hor[i] = maxOf(hor[i], grid[j][i])
            }
        }
        var ans = 0
        for (i in hor.indices) {
            for (j in ver.indices) {
                ans += minOf(ver[j], hor[i]) - grid[j][i]
            }
        }
        return ans
    }
}