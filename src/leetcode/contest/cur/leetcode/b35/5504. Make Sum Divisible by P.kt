package leetcode.contest.cur.leetcode.b35

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5504()
    s.minSubarray(intArrayOf(4, 4, 2), 7).print()
    s.minSubarray(intArrayOf(3, 1, 4, 2), 6).print()
}

class Solution5504 {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val n = nums.size
        val pre = IntArray(n)
        for (i in nums.indices) {
            if (i == 0) pre[i] = nums[i] % p
            else pre[i] = (pre[i - 1] + nums[i]) % p
        }
        if (pre[n - 1] == 0) return 0

        val map = hashMapOf<Int, Int>()
        map[0] = -1

        var ans = n
        for (i in 0 until n) {
            val x = ((pre[i] - pre[n - 1]) % p + p) % p
            if (map.containsKey(x)) ans = minOf(ans, i - map[x]!!)
            map[pre[i]] = i
        }
        return if (ans == n) -1 else ans
    }
}