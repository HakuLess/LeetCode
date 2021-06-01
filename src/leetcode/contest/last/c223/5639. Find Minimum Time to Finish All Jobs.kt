package leetcode.contest.last.c223

import leetcode.contest.utils.print
import leetcode.contest.utils.swap
import kotlin.math.exp

fun main(args: Array<String>) {
    val s = Solution5639()
//    s.minimumTimeRequired(intArrayOf(3, 2, 3), 3).print()
//    s.minimumTimeRequired(intArrayOf(1, 2, 4, 7, 8), 2).print()
//    s.minimumTimeRequired(intArrayOf(5, 15, 4, 9, 15, 8, 8, 9), 2).print()
//    s.minimumTimeRequired(intArrayOf(17, 20, 4, 6, 2, 5, 13, 5, 8), 8).print()
//    s.minimumTimeRequired(intArrayOf(79, 27, 39, 30, 22, 72, 13, 74, 67, 84, 47), 5).print()
    s.minimumTimeRequired(
        intArrayOf(
            20010,
            20006,
            20014,
            20004,
            20008,
            20006,
            20005,
            20012,
            19999,
            20014,
            20003,
            20012
        ), 8
    ).print()
//    s.minimumTimeRequired(intArrayOf(2978102, 9140986, 71464, 3828079, 8045322, 9482671, 4668155, 5705056, 2444210, 7052934, 1110498), 2).print()
}

class Solution5639 {
    // 模拟退火 最小值
    fun minimumTimeRequired(jobs: IntArray, k: Int): Int {
        val eps = 1e-5
        val delta = 0.97
        var ans = Int.MAX_VALUE
        val n = jobs.size

        fun getSum(): Int {
            val state = IntArray(k)
            for (i in jobs.indices) {
                // 每次将任务分配给当前任务最少的人
                val index = state.indexOfFirst { it == state.min()!! }
                state[index] += jobs[i]
            }
            ans = minOf(ans, state.max()!!)
            return state.max()!!
        }

        fun sa() {
            var t = 1e6
            while (t > eps) {
                val x: Int = (0 until n).random()
                val y: Int = (0 until n).random()
                val last: Int = getSum()
                jobs.swap(x, y)
                val now: Int = getSum()
                val diff = now - last
                // 取最小值
                if (diff > 0 && exp(-1.0 * diff / t) * n <= (0 until n).random()) {
                    // 还原操作
                    jobs.swap(x, y)
                }
                t *= delta
            }
        }
        repeat(20) {
            sa()
        }
        return ans
    }

    // DP 状态压缩
//    fun minimumTimeRequired(jobs: IntArray, k: Int): Int {
//        val n = jobs.size
//        val dp = Array(k + 1) { IntArray(1 shl n) { Int.MAX_VALUE } }
//        dp[0][0] = 0
//        val sum = IntArray(1 shl n)
//        for (i in 0 until (1 shl n)) {
//            for (j in 0 until n) {
//                if (i and (1 shl j) != 0) {
//                    sum[i] += jobs[j]
//                }
//            }
//        }
//        for (i in 1..k) {
//            for (state in 0 until (1 shl n)) {
//                var subState = state
//                while (subState > 0) {
//                    dp[i][state] = minOf(dp[i][state], maxOf(dp[i - 1][state - subState], sum[subState]))
//                    subState = (subState - 1) and state
//                }
//            }
//        }
//        return dp[k][(1 shl n) - 1]
//    }
}