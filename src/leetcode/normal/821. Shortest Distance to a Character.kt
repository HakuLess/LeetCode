package leetcode.normal

import java.util.*

fun shortestToChar(S: String, C: Char): IntArray {
    val s = S.toCharArray()
    val ans = IntArray(s.size) { -1 }
    val queue: Queue<Int> = LinkedList<Int>()
    for (i in 0 until s.size) {
        if (s[i] == C) {
            queue.add(i)
        }
    }
    var step = 0
    while (queue.isNotEmpty()) {
        println(queue.peek())
        val size = queue.size
        step++
        for (i in 0 until size) {
            val pos = queue.poll()
            if (ans[pos] == -1) {
                ans[pos] = step
            }
            if (pos - 1 >= 0 && ans[pos - 1] == -1) {
                queue.add(pos - 1)
            }
            if (pos + 1 < s.size && ans[pos + 1] == -1) {
                queue.add(pos + 1)
            }
        }
    }
    return ans
}