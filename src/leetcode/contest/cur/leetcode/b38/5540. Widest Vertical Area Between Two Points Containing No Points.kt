package leetcode.contest.cur.leetcode.b38

class Solution5540 {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        val st = points.sortedBy { it[0] }
        var ans = 0
        for (i in 1 until st.size) {
            ans = maxOf(ans, st[i][0] - st[i - 1][0])
        }
        return ans
    }
}