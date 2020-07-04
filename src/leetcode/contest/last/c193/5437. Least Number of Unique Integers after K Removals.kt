package leetcode.contest.last.c193

class Solution5437 {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val l = arr.groupBy { it }.map {
            it.value.size
        }.sorted()
        var ans = l.size
        var last = k
        for (i in l.indices) {
            last -= l[i]
            ans--
            if (last < 0) {
                ans++
                break
            }
        }
        return ans
    }
}