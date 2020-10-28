package leetcode.contest.cur.leetcode.c212

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution1631()
    //    [[1,2,2],[3,8,2],[5,3,5]]
    s.minimumEffortPath(
            arrayOf(
                    intArrayOf(1, 2, 2),
                    intArrayOf(3, 8, 2),
                    intArrayOf(5, 3, 5)
            )
    ).print()
}

class Solution1631 {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val x = intArrayOf(1, 0, -1, 0)
        val y = intArrayOf(0, 1, 0, -1)
        val queue: Queue<Triple<Int, Int, Int>> = LinkedList<Triple<Int, Int, Int>>()
        queue.add(Triple(0, 0, 0))
        val seen = HashMap<Pair<Int, Int>, Int>()
        var ans = Int.MAX_VALUE
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                val key = Pair(item.first, item.second)
                if (item.first == heights.lastIndex && item.second == heights[0].lastIndex) {
                    ans = minOf(ans, item.third)
                }
                if (key !in seen.keys || seen[key]!! > item.third) {
                    seen[key] = item.third
                    for (i in 0 until 4) {
                        val next = Pair(item.first + x[i], item.second + y[i])
                        if (next.first in heights.indices && next.second in heights[0].indices) {
                            queue.offer(Triple(next.first, next.second,
                                    maxOf(item.third, abs(heights[item.first][item.second] - heights[next.first][next.second]))))
                        }
                    }
                }
            }
        }
        return ans
    }
}