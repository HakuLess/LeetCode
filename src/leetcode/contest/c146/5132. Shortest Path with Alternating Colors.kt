package leetcode.contest.c146

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5132()
    s.shortestAlternatingPaths(
            5,
            arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
            ),
            arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 1)
            )
    ).print()
}

class Solution5132 {
    fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
        val ans = IntArray(n) { -1 }
        ans[0] = 0
        val redQueue: Queue<Int> = LinkedList<Int>()
        val blueQueue: Queue<Int> = LinkedList<Int>()
        redQueue.add(0)
        blueQueue.add(0)
        val seen = hashSetOf<IntArray>()
        var step = 0
        while (redQueue.isNotEmpty() && step < n * 3) {
            step++
            val size = redQueue.size
            for (i in 0 until size) {
                val item = redQueue.poll()
                val edge = if (step % 2 == 0) {
                    red_edges
                } else {
                    blue_edges
                }
                edge.forEach {
                    if (it[0] == item && it !in seen) {
                        redQueue.offer(it[1])
                        seen.add(it)
                        ans[it[1]] = if (ans[it[1]] >= 0) {
                            minOf(step, ans[it[1]])
                        } else {
                            step
                        }
                    }
                }
            }
        }

        step = 0
        seen.clear()
        while (blueQueue.isNotEmpty() && step < n * 3) {
            step++
            val size = blueQueue.size
            for (i in 0 until size) {
                val item = blueQueue.poll()
//                println("$item $step")
                val edge = if (step % 2 == 0) {
                    blue_edges
                } else {
                    red_edges
                }
                edge.forEach {
                    if (it[0] == item && it !in seen) {
                        blueQueue.offer(it[1])
                        seen.add(it)
                        ans[it[1]] = if (ans[it[1]] >= 0) {
                            minOf(step, ans[it[1]])
                        } else {
                            step
                        }
                    }
                }
            }
        }
        return ans
    }
}