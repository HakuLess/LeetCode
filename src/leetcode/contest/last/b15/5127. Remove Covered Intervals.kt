package leetcode.contest.last.b15

// todo not finished
class Solution5127 {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        val list = intervals.sortedWith(compareBy({ it[0] }, { -it[1] }))
        var cur = list[0]
        var ans = 0
        for (i in 1 until list.size) {
            if (list[i][1] <= cur[1] && list[i][0] >= cur[0]) {
                continue
            } else {
                ans++
                cur = list[i]
            }
        }
        return ans
    }
}