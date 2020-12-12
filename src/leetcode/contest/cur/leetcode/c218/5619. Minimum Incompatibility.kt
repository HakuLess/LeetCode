package leetcode.contest.cur.leetcode.c218

import leetcode.contest.utils.print
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) {
    val s = Solution5619()
    s.minimumIncompatibility(intArrayOf(1, 2, 1, 4), 2).print()
//    s.minimumIncompatibility(intArrayOf(6, 3, 8, 1, 3, 1, 2, 2), 4).print()
//    s.minimumIncompatibility(intArrayOf(10, 5, 6, 5, 6, 3, 6, 4, 2, 3), 10).print()
//    s.minimumIncompatibility(intArrayOf(4, 10, 4, 7, 9, 10, 4, 6, 9, 10), 5).print()
//    s.minimumIncompatibility(intArrayOf(5, 3, 3, 6, 3, 3), 3).print()
    measureTimeMillis {
        //        s.minimumIncompatibility(intArrayOf(13, 4, 7, 3, 3, 1, 12, 9, 11, 10, 13, 3, 12, 7), 7).print()
//        s.minimumIncompatibility(intArrayOf(2, 8, 2, 9, 2, 8, 2, 9, 6, 8, 6, 8), 6).print()
        s.minimumIncompatibility(intArrayOf(11, 11, 3, 4, 2, 16, 14, 13, 6, 14, 2, 5, 10, 13, 5, 7), 8).print()
    }.also {
        it.print()
    }
}

class Solution5619 {

    fun minimumIncompatibility(nums: IntArray, k: Int): Int {
        val n = nums.size / k
        val size = nums.size
        val dp = IntArray(1 shl size) { Int.MAX_VALUE / 2 }
        for (state in dp.indices) {
            if (Integer.bitCount(state) == n) {
                val num = IntArray(size + 1)
                for (i in num.indices) {
                    if (state.and(1 shl i) != 0) {
                        num[nums[i]]++
                    }
                }
                if (num.all { it <= 1 }) {
                    dp[state] = num.indexOfLast { it == 1 } - num.indexOfFirst { it == 1 }
                }
            } else if (Integer.bitCount(state) % n == 0) {
                var sub = state
                while (sub != 0) {
                    sub = state.and(sub - 1)
                    if (Integer.bitCount(sub) == n) {
                        dp[state] = minOf(dp[state], dp[sub] + dp[state.and(sub.inv())])
                    }
                }
            }
        }
        dp.last().let {
            if (it >= Int.MAX_VALUE / 2) return -1
            return it
        }
    }

//    fun minimumIncompatibility(nums: IntArray, k: Int): Int {
//        var ans = Int.MAX_VALUE
//        val sets: Array<TreeSet<Int>> = Array<TreeSet<Int>>(k) { TreeSet() }
//        for (i in 0 until k) {
//            sets[i] = TreeSet()
//        }
//        fun dfs(index: Int, nums: IntArray, sets: Array<TreeSet<Int>>) {
//            if (index == nums.size) {
//                var sum = 0
//                for (set in sets) {
//                    sum += set.last() - set.first()
//                }
//                ans = minOf(ans, sum)
//                return
//            }
//            for (set in sets) {
//                if (set.size < nums.size / sets.size && !set.contains(nums[index])) {
//                    set.add(nums[index])
//                    dfs(index + 1, nums, sets)
//                    set.remove(nums[index])
//                    if (set.isEmpty()) break
//                }
//            }
//        }
//        dfs(0, nums, sets)
//        return if (ans == Int.MAX_VALUE) -1 else ans
//    }
}