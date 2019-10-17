package leetcode.contest.last.b09

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5073()
    s.minKnightMoves(2, 112).print()
    s.minKnightMoves(5, 5).print()
}

class Solution5073 {
    fun minKnightMoves(x: Int, y: Int): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(0, 0))
        val set = HashSet<Pair<Int, Int>>()
        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first == abs(x) && item.second == abs(y)) {
                    return step
                }
                if (item !in set && item.first >= 0 && item.second >= 0 && abs(item.first) + abs(item.second) < 310) {
                    set.add(item)
                    queue.offer(Pair(item.first + 1, item.second + 2))
                    queue.offer(Pair(item.first + 1, item.second - 2))
                    queue.offer(Pair(item.first + 2, item.second + 1))
                    queue.offer(Pair(item.first + 2, item.second - 1))
                    queue.offer(Pair(item.first - 1, item.second + 2))
                    queue.offer(Pair(item.first - 1, item.second - 2))
                    queue.offer(Pair(item.first - 2, item.second + 1))
                    queue.offer(Pair(item.first - 2, item.second - 1))
                }
            }
        }
        return -1
    }
}