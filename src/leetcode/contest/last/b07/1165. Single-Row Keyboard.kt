package leetcode.contest.last.b07

import kotlin.math.abs

class Solution1165 {
    fun calculateTime(keyboard: String, word: String): Int {
        var cur = 0
        var ans = 0
        word.forEach {
            val index = keyboard.indexOf(it)
            ans += abs(index - cur)
            cur = index
        }
        return ans
    }
}