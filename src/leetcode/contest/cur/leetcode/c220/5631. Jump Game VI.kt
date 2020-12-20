package leetcode.contest.cur.leetcode.c220

import leetcode.contest.utils.print
import leetcode.contest.utils.toIntArray
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5631()
    s.maxResult("[1,-1,-2,4,-7,3]".toIntArray(), 2).print()
}

class Solution5631 {
    fun maxResult(nums: IntArray, k: Int): Int {
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { -it.second })
        pq.offer(Pair(0, nums[0]))
        for (i in 1 until nums.size) {
            while (pq.isNotEmpty() && pq.peek().first < i - k) {
                pq.poll()
            }
            dp[i] = pq.peek().second + nums[i]
            pq.offer(Pair(i, dp[i]))
        }
        dp.print()
        return dp.last()
    }
}