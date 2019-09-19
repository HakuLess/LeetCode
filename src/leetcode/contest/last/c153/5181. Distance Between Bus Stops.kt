package leetcode.contest.last.c153

fun main(args: Array<String>) {
    val s = Solution5181()
}

class Solution5181 {
    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        val sum = distance.sum()
        var ans = 0
        for (i in minOf(start, destination) until maxOf(start, destination)) {
            ans += distance[i]
        }
        ans = minOf(ans, sum - ans)
        return ans
    }
}