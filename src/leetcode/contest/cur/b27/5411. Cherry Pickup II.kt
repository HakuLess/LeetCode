package leetcode.contest.cur.b27

class Solution5411 {
    val seen = HashMap<Triple<Int, Int, Int>, Int>()
    val z = listOf(
            arrayOf(-1, 1, 0),
            arrayOf(-1, 1, 0)
    )
    var row = 0
    var col = 0
    fun cherryPickup(grid: Array<IntArray>): Int {
        row = grid.size
        col = grid[0].size
        return helper(0, 0, col - 1, grid) + grid[0][0] + grid[0][col - 1]
    }

    private fun helper(i: Int, left: Int, right: Int, grid: Array<IntArray>): Int {
        if (i == row - 1) {
            return 0
        }
        if (Triple(i, left, right) in seen) {
            return seen[Triple(i, left, right)]!!
        }
        var ans = 0
        for (dl in z[0]) {
            for (dr in z[1]) {
                val nl = left + dl
                val nr = right + dr
                if (nl in 0 until nr && nr < col) {
                    ans = maxOf(ans, helper(i + 1, nl, nr, grid) + grid[i + 1][nl] + grid[i + 1][nr])
                }
            }
        }
        seen[Triple(i, left, right)] = ans
        return ans
    }
}