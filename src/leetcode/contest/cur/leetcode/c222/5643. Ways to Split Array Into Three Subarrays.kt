package leetcode.contest.cur.leetcode.c222

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5643()
    s.waysToSplit(intArrayOf(1, 2, 2, 2, 5, 0)).print()
    s.waysToSplit(intArrayOf(1, 1, 1)).print()
    s.waysToSplit(intArrayOf(0, 3, 3)).print()
    s.waysToSplit(intArrayOf(3, 2, 1)).print()
    s.waysToSplit(intArrayOf(1, 0, 3, 0, 5)).print()

    s.waysToSplit(intArrayOf(0, 0, 0, 0)).print()
}

class Solution5643 {
    fun waysToSplit(nums: IntArray): Int {
        val mod = 1000000007L
        val n: Int = nums.size
        val preSum = IntArray(n + 1)
        val map = TreeMap<Int, ArrayList<Int>>()
        for (i in 0 until n) {
            preSum[i + 1] = preSum[i] + nums[i]
            map[preSum[i + 1]] = map.getOrDefault(preSum[i + 1], arrayListOf())
            map[preSum[i + 1]]!!.add(i)
        }
        val sum = preSum.last()
        var left = 0
        var ans = 0L
        for (i in 0 until n - 2) {
            left += nums[i]
            val mid = map.ceilingEntry(left * 2)?.value?.first() ?: continue
            val right = map.floorEntry((sum + left) / 2)?.value?.last() ?: continue
            if (right < mid) continue

//            println("find between ${left * 2} and ${(sum + left) / 2}")
//            println("${right} - ${maxOf(i + 1, mid)}")
            ans += minOf(right, n - 2) - maxOf(i + 1, mid) + 1
        }
        return (ans % mod).toInt()
    }

//    fun waysToSplit(nums: IntArray): Int {
//        val n: Int = nums.size
//        val psum = IntArray(n + 1)
//        for (i in 0 until n) {
//            psum[i + 1] = psum[i] + nums[i]
//        }
//        var res = 0
//        var a = 1
//        var b = 1
//        for (i in 0 until n - 2) {
//            a = maxOf(i + 1, a)
//            while (a < n - 1 && psum[a + 1] - psum[i + 1] < psum[i + 1]) {
//                a++
//            }
//            if (a == n - 1) {
//                break
//            }
//            b = maxOf(b, a)
//            while (b < n - 1 && psum[n] - psum[b + 1] >= psum[b + 1] - psum[i + 1]) {
//                b++
//            }
//            res = (res + (b - a)) % 1000000007
//        }
//        return res
//    }
}