package leetcode.contest.last.c237

import java.util.*

class Solution5736 {
    // 任务队列执行
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val queue = PriorityQueue<Triple<Long, Long, Int>>(compareBy { it.first })
        for (i in tasks.indices) {
            queue.offer(Triple(tasks[i][0].toLong(), tasks[i][1].toLong(), i))
        }
        var cur: Long = queue.peek().first
        val ans = arrayListOf<Int>()
        val curQueue = PriorityQueue<Triple<Long, Long, Int>>(compareBy({ it.second }, { it.third }))
        while (queue.isNotEmpty() || curQueue.isNotEmpty()) {
            while (queue.isNotEmpty() && queue.peek().first <= cur) {
                curQueue.offer(queue.poll())
            }
            if (curQueue.isNotEmpty()) {
                val item = curQueue.poll()
                ans.add(item.third)
                cur += item.second
            } else {
                cur = queue.peek().first
            }
        }
        return ans.toIntArray()
    }
}