package leetcode.contest.cur.leetcode.b35

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5505()
    s.maxSumRangeQuery(intArrayOf(1, 2, 3, 4, 5), arrayOf(
            intArrayOf(1, 3),
            intArrayOf(0, 1)
    )).print()
}

class Solution5505 {
    fun maxSumRangeQuery(nums: IntArray, requests: Array<IntArray>): Int {
        val mod = (1e9 + 7).toLong()
        val st = nums.sortedDescending()
        val arr = IntArray(nums.size + 1)
        requests.forEach {
            arr[it[0]]++
            arr[it[1] + 1]--
        }
        for (i in 1..arr.lastIndex) {
            arr[i] += arr[i - 1]
        }
        arr.sortDescending()
        var ans = 0L
        for (i in st.indices) {
            ans += st[i] * arr[i]
        }
        return (ans % mod).toInt()
    }
}