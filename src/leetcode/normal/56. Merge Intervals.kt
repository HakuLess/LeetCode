package leetcode.normal

class Solution56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) {
            return emptyArray()
        }
        val ans = ArrayList<IntArray>()
        intervals.sortBy { it[0] }
        var cur = IntArray(2)
        for (i in intervals.indices) {
            if (i == 0) {
                cur = intervals[i]
            } else {
                if (intervals[i][0] <= cur[1]) {
                    cur[1] = maxOf(intervals[i][1], cur[1])
                } else {
                    ans.add(cur)
                    cur = intervals[i]
                }
            }
        }
        ans.add(cur)
        return ans.toTypedArray()
    }
}