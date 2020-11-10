package leetcode.normal

import java.util.*

class Solution696 {
    fun countBinarySubstrings(s: String): Int {
        val counts = ArrayList<Int>()
        var ptr = 0
        val n: Int = s.length
        while (ptr < n) {
            val c: Char = s[ptr]
            var count = 0
            while (ptr < n && s[ptr] == c) {
                ++ptr
                ++count
            }
            counts.add(count)
        }
        var ans = 0
        for (i in 1 until counts.size) {
            ans += minOf(counts[i], counts[i - 1])
        }
        return ans
    }
}