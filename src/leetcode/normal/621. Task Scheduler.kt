package leetcode.normal

import java.util.*


class Solution621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = HashMap<Char, Int>()
        var maxExec = 0
        for (ch in tasks) {
            val exec = freq.getOrDefault(ch, 0) + 1
            freq[ch] = exec
            maxExec = maxOf(maxExec, exec)
        }
        var maxCount = 0
        for ((_, value) in freq.entries) {
            if (value == maxExec) {
                ++maxCount
            }
        }
        return maxOf((maxExec - 1) * (n + 1) + maxCount, tasks.size)
    }
}