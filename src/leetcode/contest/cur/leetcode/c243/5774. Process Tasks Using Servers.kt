package leetcode.contest.cur.leetcode.c243

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5774()
//    s.assignTasks(intArrayOf(3, 3, 2), intArrayOf(1, 2, 3, 2, 1, 2)).print()
//    s.assignTasks(intArrayOf(10, 63, 95, 16, 85, 57, 83, 95, 6, 29, 71), intArrayOf(70, 31, 83, 15, 32, 67, 98, 65, 56, 48, 38, 90, 5)).print()
    s.assignTasks(intArrayOf(31, 96, 73, 90, 15, 11, 1, 90, 72, 9, 30, 88), intArrayOf(87, 10, 3, 5, 76, 74, 38, 64, 16, 64, 93, 95, 60, 79, 54, 26, 30, 44, 64, 71)).print()
}

// 时间分配
class Solution5774 {
    fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
        val ready = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.first }, { it.second }))
        for (i in servers.indices) {
            ready.offer(Triple(servers[i], i, 0))
        }
        val doing = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.third }, { it.first }, { it.second }))
        val ans = ArrayList<Int>()
        var ts = 0
        for (i in tasks.indices) {
            // 记录当前已到达的时间
            ts = maxOf(ts, i)
            // 能出队的尽量都出队
            while (doing.isNotEmpty() && doing.peek().third <= ts) {
                val it = doing.poll()
                ready.offer(Triple(it.first, it.second, 0))
            }
            val item = ready.poll() ?: doing.poll()
            ans.add(item.second)
            if (item.third != 0) {
                ts = item.third
            }
            doing.offer(Triple(item.first, item.second, ts + tasks[i]))
        }
        return ans.toIntArray()
    }
}