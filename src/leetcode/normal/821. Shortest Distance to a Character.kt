package leetcode.normal

import java.util.*

class Solution821 {
    fun shortestToChar(S: String, C: Char): IntArray {
        val s = S.toCharArray()
        val ans = IntArray(s.size) { -1 }
        val queue: Queue<Int> = LinkedList<Int>()
        for (i in s.indices) {
            if (s[i] == C) {
                queue.add(i)
            }
        }
        var step = -1
        while (queue.isNotEmpty()) {
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
}