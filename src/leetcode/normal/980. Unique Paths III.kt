package leetcode.normal

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution980()
    s.uniquePathsIII(arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 2, -1)
    )).print()

    s.uniquePathsIII(arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 2)
    )).print()

    s.uniquePathsIII(arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 0)
    )).print()
}

class Solution980 {
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var start = Pair(0, 0)
        var end = Pair(0, 0)
        var sum = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 1) {
                    start = Pair(i, j)
                } else if (grid[i][j] == 2) {
                    end = Pair(i, j)
                }

                if (grid[i][j] != -1) {
                    sum++
                }
            }
        }

        var ans = 0
        val queue: Queue<Pair<Pair<Int, Int>, HashSet<Pair<Int, Int>>>> =
                LinkedList<Pair<Pair<Int, Int>, HashSet<Pair<Int, Int>>>>()
        queue.add(Pair(start, hashSetOf()))
        while (queue.isNotEmpty()) {
            val size = queue.size
//            println(size)
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first.first !in 0..grid.lastIndex ||
                        item.first.second !in 0..grid[0].lastIndex ||
                        grid[item.first.first][item.first.second] == -1 ||
                        item.first in item.second) {
                    continue
                }
//                println(item.first)
                if (item.first == end && item.second.size == sum - 1) {
//                    println("${item.second.size}: $sum")
                    ans++
                } else {
                    val p = item.first
                    val s = item.second
                    s.add(p)
                    queue.offer(Pair(Pair(p.first - 1, p.second), HashSet(s)))
                    queue.offer(Pair(Pair(p.first + 1, p.second), HashSet(s)))
                    queue.offer(Pair(Pair(p.first, p.second - 1), HashSet(s)))
                    queue.offer(Pair(Pair(p.first, p.second + 1), HashSet(s)))
                }
            }
        }
        return ans
    }
}