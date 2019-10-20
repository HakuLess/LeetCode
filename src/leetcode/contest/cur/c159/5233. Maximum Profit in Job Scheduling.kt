package leetcode.contest.cur.c159

class Solution5233 {

    private val map = HashMap<Int, Int>()

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val w = arrayListOf<Triple<Int, Int, Int>>()
        for (i in startTime.indices) {
            w.add(Triple(startTime[i], endTime[i], profit[i]))
        }
        w.sortBy { it.first }
        return helper(w, 0)
    }

    private fun helper(w: List<Triple<Int, Int, Int>>, now: Int): Int {
        if (map.containsKey(now)) {
            return map[now]!!
        }
        val left = w.filter { it.first >= now }
        if (left.isEmpty()) {
            return 0
        }

        var res = 0
        for (i in left.indices) {
            res = maxOf(res, helper(left, left[i].second) + left[i].third)
        }

        map[now] = res
        return res
    }
}