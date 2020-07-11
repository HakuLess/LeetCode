package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution174()
//    s.calculateMinimumHP(arrayOf(
//            intArrayOf(-2, -3, 3),
//            intArrayOf(-5, -10, 1),
//            intArrayOf(10, 30, -5)
//    )).print()

    s.calculateMinimumHP(arrayOf(
            intArrayOf(0, 0)
    )).print()
}

class Solution174 {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val n = dungeon.size
        val m = dungeon[0].size
        val dp = Array<IntArray>(n + 1) { IntArray(m + 1) { Int.MAX_VALUE } }
        dp[n][m - 1] = 1
        dp[n - 1][m] = 1
        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                val min = minOf(dp[i + 1][j], dp[i][j + 1])
                dp[i][j] = maxOf(min - dungeon[i][j], 1)
            }
        }
        return dp[0][0]
    }

//    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
//        val queue: Queue<IntArray> = LinkedList<IntArray>()
//        queue.add(intArrayOf(0, 0, 0, 0))
//        var ans = Int.MAX_VALUE
//        while (queue.isNotEmpty()) {
//            val size = queue.size
//            for (i in 0 until size) {
//                val item = queue.poll()
//                item.print()
//                if (item[0] !in dungeon.indices || item[1] !in dungeon[0].indices) {
//                    continue
//                }
//                val x = item[0]
//                val y = item[1]
//                val cur = item[3] + dungeon[x][y]
//                val min = minOf(item[2], cur)
//                queue.offer(intArrayOf(x + 1, y, min, cur))
//                queue.offer(intArrayOf(x, y + 1, min, cur))
//
//                println("${dungeon.lastIndex} ${dungeon[0].lastIndex}")
//                if (x == dungeon.lastIndex && y == dungeon[0].lastIndex) {
//                    ans = minOf(ans, -min)
//                    println("set ans ${min}")
//                }
//            }
//        }
//        return ans + 1
//    }
}