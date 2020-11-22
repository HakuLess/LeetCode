package leetcode.contest.cur.leetcode.b39

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution1654()
    s.minimumJumps(intArrayOf(14, 4, 18, 1, 15), 3, 15, 9).print()
    s.minimumJumps(intArrayOf(1998), 1999, 2000, 2000).print()
}

class Solution1654 {
    fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
        val queue: Queue<Pair<Int, Boolean>> = LinkedList<Pair<Int, Boolean>>()
        queue.add(Pair(0, false))
        var step = -1
        val seen = HashSet<Pair<Int, Boolean>>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            if (step > 8000) return -1
            for (i in 0 until size) {
                val item = queue.poll()
                println("$step $item")
                if (item.first in forbidden) continue
                if (item in seen) continue
                if (item.first < 0) continue
                if (item.first > 8000) continue
                if (item.first == x) return step
                seen.add(item)
                if (!item.second) {
                    queue.offer(Pair(item.first - b, true))
                }
                queue.offer(Pair(item.first + a, false))
            }
        }
        return -1
    }
}