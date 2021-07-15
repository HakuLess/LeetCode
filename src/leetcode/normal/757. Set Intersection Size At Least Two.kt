package leetcode.normal

class Solution757 {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy({ it[0] }, { -it[1] }))
        val needs = IntArray(intervals.size) { 2 }
        var ans = 0
        for (i in intervals.indices.reversed()) {
            val need = needs[i]
            val s = intervals[i][0]
            for (p in s until s + need) {
                for (j in intervals.indices) {
                    if (needs[j] > 0 && p <= intervals[j][1]) {
                        needs[j]--
                    }
                }
                ans++
            }
        }
        return ans
    }
}