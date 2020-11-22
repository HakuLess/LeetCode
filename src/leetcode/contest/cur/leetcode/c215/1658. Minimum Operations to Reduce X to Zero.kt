package leetcode.contest.cur.leetcode.c215

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1658()
    s.minOperations(intArrayOf(1, 1, 4, 2, 3), 5).print()
    s.minOperations(intArrayOf(3, 2, 20, 1, 1, 3), 10).print()
}

class Solution1658 {
    fun minOperations(nums: IntArray, x: Int): Int {
        if (nums.sum() < x) return -1
        if (nums.sum() == x) return nums.size
        val pre = IntArray(nums.size)
        val suf = IntArray(nums.size)
        val sufMap = HashMap<Int, Int>()
        for (i in nums.indices) {
            pre[i] = nums[i] + if (i != 0) pre[i - 1] else 0
        }
        for (i in nums.indices.reversed()) {
            suf[i] = nums[i] + if (i != nums.lastIndex) suf[i + 1] else 0
            sufMap[suf[i]] = nums.size - i
        }
        var ans = Int.MAX_VALUE
        for (i in nums.indices) {
            if (pre[i] == x) ans = minOf(ans, i + 1)
            else if (pre[i] > x) break
            else {
                val res = sufMap.getOrDefault(x - pre[i], Int.MAX_VALUE / 2)
                if (res >= 0) {
                    ans = minOf(ans, i + res + 1)
                }
            }
        }
        val l = suf.reversed().indexOf(x)
        if (l >= 0) {
            ans = minOf(ans, l + 1)
        }
        return if (ans >= Int.MAX_VALUE / 2) -1 else ans
    }
}