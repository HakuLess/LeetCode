package leetcode.contest.cur.leetcode.b42

import leetcode.contest.utils.print
import leetcode.contest.utils.toIntArray

fun main(args: Array<String>) {
    val s = Solution5624()
    s.minMoves("[1,0,0,1,0,1]".toIntArray(), 2).print()
    s.minMoves("[0,1,1,0,1,0]".toIntArray(), 2).print()
}

class Solution5624 {
    fun minMoves(nums: IntArray, k: Int): Int {
        var ans = Int.MAX_VALUE
        val l = arrayListOf<Int>()
        var cur = 0
        for (i in nums.indices) {
            if (nums[i] != 1) {
                continue
            }
            if (l.size < k) {
                l.add(i)
                val mid = l[(l.size - 1) / 2]
                cur += (i - mid) - (l.size / 2)
            } else {
                ans = minOf(ans, cur)
                var mid = l[l.size / 2]
                l.add(i)
                cur += i - mid

                mid = l[l.size / 2]
                val j = l.removeAt(0)
                cur -= mid - j
            }
        }
        return minOf(ans, cur)
    }

//    fun minMoves(nums: IntArray, k: Int): Int {
//        if (k == 1) {
//            return 0
//        }
//        val n = nums.size
//        val g = arrayListOf<Int>()
//        val sum = arrayListOf<Int>()
//        sum.add(0)
//        var count = -1
//        for (i in nums.indices) {
//            if (nums[i] == 1) {
//                ++count
//                g.add(i - count)
//                sum.add(sum.last() + g.last())
//            }
//        }
//
//        val m = g.size
//        var ans = Int.MAX_VALUE
//        var i = 0
//        while (i + k <= m) {
//            val mid = (i + i + k - 1) / 2
//            val q = g[mid]
//            ans = minOf(ans, (2 * (mid - i) - k + 1) * q + (sum[i + k] - sum[mid + 1]) - (sum[mid] - sum[i]))
//            i++
//        }
//        return ans
//    }
}