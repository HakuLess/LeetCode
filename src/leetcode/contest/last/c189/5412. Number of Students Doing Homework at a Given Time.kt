package leetcode.contest.last.c189

class Solution5412 {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        val list = arrayListOf<Pair<Int, Int>>()
        for (i in startTime.indices) {
            list.add(Pair(startTime[i], endTime[i]))
        }
        return list.filter {
            it.first <= queryTime && it.second >= queryTime
        }.count()
    }
}