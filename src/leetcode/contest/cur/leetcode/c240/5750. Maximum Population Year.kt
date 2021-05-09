package leetcode.contest.cur.leetcode.c240

class Solution5750 {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        var max = 0
        var ans = -1
        for (i in 1950..2050) {
            val cnt = logs.count { it[0] <= i && it[1] - 1 >= i }
            if (cnt > max) {
                max = cnt
                ans = i
            }
        }
        return ans
    }
}