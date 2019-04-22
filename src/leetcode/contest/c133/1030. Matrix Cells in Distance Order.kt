package leetcode.contest.c133

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1030()
    s.allCellsDistOrder(2, 3, 1, 2).print()
}

class Solution1030 {
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        val ans = arrayListOf<IntArray>()
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(r0, c0))

        val set = hashSetOf<Pair<Int, Int>>()

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first >= 0 && item.second >= 0 && item.first < R && item.second < C
                        && Pair(item.first, item.second) !in set) {

                    ans.add(intArrayOf(item.first, item.second))

                    set.add(Pair(item.first, item.second))

                    queue.add(Pair(item.first - 1, item.second))
                    queue.add(Pair(item.first + 1, item.second))
                    queue.add(Pair(item.first, item.second - 1))
                    queue.add(Pair(item.first, item.second + 1))
                }
            }
        }

        return ans.toTypedArray()
    }
}