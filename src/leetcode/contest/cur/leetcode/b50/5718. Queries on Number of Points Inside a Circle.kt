package leetcode.contest.cur.leetcode.b50

class Solution5718 {
    fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val ans = arrayListOf<Int>()
        queries.forEach {
            var res = 0
            for (i in points.indices) {
                if ((points[i][0] - it[0]) * (points[i][0] - it[0]) +
                        (points[i][1] - it[1]) * (points[i][1] - it[1]) <= it[2] * it[2]) {
                    res++
                }
            }
            ans.add(res)
        }
        return ans.toIntArray()
    }
}