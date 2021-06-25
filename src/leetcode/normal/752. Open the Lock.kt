package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution752()
    s.openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202").print()
}

class Solution752 {
    fun openLock(deadends: Array<String>, target: String): Int {
        if ("0000" in deadends) {
            return -1
        }
        var ans = -1
        val queue: Queue<String> = LinkedList<String>()
        queue.add("0000")
        val hashSet = hashSetOf<String>()
        hashSet.add("0000")
        while (queue.isNotEmpty()) {
            ans++
            val size = queue.size
            for (num in 0 until size) {
                val str = queue.poll()
                if (str == target) {
                    return ans
                }
                for (i in 0..8) {
                    val sb = StringBuilder(str)
                    sb[i % 4] = if (i < 4) {
                        ('0' + ((sb[i % 4] - '0' + 1) % 10))
                    } else {
                        ('0' + ((sb[i % 4] - '0' + 9) % 10))
                    }
                    if (sb.toString() !in hashSet && sb.toString() !in deadends) {
                        hashSet.add(sb.toString())
                        queue.add(sb.toString())
                    }
                }
            }
        }
        return -1
    }
}