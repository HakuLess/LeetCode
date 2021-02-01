package leetcode.contest.cur.leetcode.c212

import leetcode.contest.utils.print
import java.util.*
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

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val m = heights.size
        val n: Int = heights[0].size
        var left = 0
        var right = 999999
        var ans = 0
        while (left <= right) {
            val mid = (left + right) / 2
            val queue: Queue<IntArray> = LinkedList()
            queue.offer(intArrayOf(0, 0))
            val seen = BooleanArray(m * n)
            seen[0] = true
            while (!queue.isEmpty()) {
                val cell = queue.poll()
                val x = cell[0]
                val y = cell[1]
                for (i in 0..3) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    if (nx in 0 until m && ny in 0 until n
                            && !seen[nx * n + ny]
                            && abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        queue.offer(intArrayOf(nx, ny))
                        seen[nx * n + ny] = true
                    }
                }
            }
            if (seen[m * n - 1]) {
                ans = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return ans
    }
}