package leetcode.contest.cur.leetcode.c235

import leetcode.contest.utils.print
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5724()
    s.minAbsoluteSumDiff(intArrayOf(1, 7, 5), intArrayOf(2, 3, 5)).print()
}

class Solution5724 {
    fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
        val mod = 1000000007L
        var ans = 0L
        for (i in nums1.indices) {
            ans += abs(nums1[i] - nums2[i])
        }
        val ts = TreeSet<Int>()
        nums1.forEach {
            ts.add(it)
        }
        var res = ans
        for (i in nums1.indices) {
            if (ts.ceiling(nums2[i]) != null)
                res = minOf(res, ans - abs(nums1[i] - nums2[i]) + abs(ts.ceiling(nums2[i]) - nums2[i]))
            if (ts.floor(nums2[i]) != null)
                res = minOf(res, ans - abs(nums1[i] - nums2[i]) + abs(ts.floor(nums2[i]) - nums2[i]))
        }
        return (res % mod).toInt()
    }
}