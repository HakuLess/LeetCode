package leetcode.contest.cur.c176

class Solution5340 {
    fun countNegatives(grid: Array<IntArray>): Int {
        var ans = 0
        grid.forEach {
            ans += it.count {
                it < 0
            }
        }
        return ans
    }
}