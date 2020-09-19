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
        val st = nums.sorted().reversed()
        val cur = IntArray(nums.size)
        requests.forEach {
            for (i in it[0]..it[1]) {
                cur[i]++
            }
        }
        val mt = cur.sorted().reversed()
        println(st.joinToString(", "))
        println(mt.joinToString(", "))
        var ans = 0L
        for (i in st.indices) {
            println("${st[i]}  x  ${mt[i]}")
            ans += st[i] * mt[i]
        }
        return (ans % mod).toInt()
    }
}