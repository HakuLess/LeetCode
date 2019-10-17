package leetcode.contest.last.b10

import java.util.*

fun main(args: Array<String>) {
    val s = Solution5081()
    s.countSteppingNumbers(0, 21).forEach {
        print("$it, ")
    }
    println()
}

class Solution5081 {
    fun countSteppingNumbers(low: Int, high: Int): List<Int> {
        val ans = arrayListOf<Int>()
        val queue: Queue<String> = LinkedList()
        for (i in 0 until 9) {
            queue.add(('1' + i).toString())
        }
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                val res = item.toIntOrNull() ?: continue
                ans.add(res)
                if (item.last() - 1 in '0'..'9') {
                    queue.offer(item + (item.last() - 1))
                }
                if (item.last() + 1 in '0'..'9') {
                    queue.offer(item + (item.last() + 1))
                }
            }
        }
        ans.add(0)
        ans.sort()
        return ans.filter {
            it in low..high
        }
    }
}