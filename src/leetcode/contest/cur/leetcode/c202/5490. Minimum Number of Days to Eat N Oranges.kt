package leetcode.contest.cur.leetcode.c202

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5490()
//    s.minDays(56).print()
    s.minDays(2000000000).print()
}

class Solution5490 {

    fun minDays(n: Int): Int {
        val seen = HashSet<Int>()
        val queue: Deque<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

        fun branch(steps: Int, k: Int) {
            if (k !in seen) {
                seen.add(k)
                queue.offer(Pair(k, steps + 1))
            }
        }
        queue.add(Pair(n, 1))
        while (true) {
            val (j, step) = queue.pop()
            if (j == 1) return step
            if (j % 3 == 0)
                branch(step, j / 3)
            if (j % 2 == 0)
                branch(step, j / 2)
            branch(step, j - 1)
        }
    }

//    fun minDays(n: Int): Int {
//        val dp = IntArray(maxOf(4, n + 1)) { Int.MAX_VALUE }
//        dp[0] = 0
//        dp[1] = 1
//        dp[2] = 2
//        dp[3] = 2
//        for (i in 4..dp.lastIndex) {
//            dp[i] = dp[i - 1] + 1
//            if (i % 3 == 0) {
//                dp[i] = minOf(dp[i / 3] + 1, dp[i])
//            }
//            if (i % 2 == 0) {
//                dp[i] = minOf(dp[i / 2] + 1, dp[i])
//            }
//        }
//        dp.print()
//        return dp[n]
//    }
}