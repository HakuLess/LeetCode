package leetcode.contest.cur.leetcode.b31

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5459()
    s.minNumberOperations(intArrayOf(1, 2, 3, 2, 1)).print()
}

class Solution5459 {
    fun minNumberOperations(target: IntArray): Int {
        var cur = target[0]
        var ans = target[0]
        for (i in 1 until target.size) {
            cur = minOf(cur, target[i])
            if (target[i] > cur) {
                ans += target[i] - cur
                cur = target[i]
            }
        }
        return ans
    }
}