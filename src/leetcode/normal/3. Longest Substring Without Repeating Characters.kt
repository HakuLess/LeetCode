package leetcode.normal

import leetcode.contest.utils.print
import java.util.HashMap


fun main(args: Array<String>) {
    lengthOfLongestSubstring("abba").print()
}

fun lengthOfLongestSubstring(s: String): Int {
    var ans = 0
    val map = HashMap<Char, Int>()
    var last = 0
    s.forEachIndexed { index, c ->
        if (map.containsKey(c)) {
            last = maxOf(map[c]!!, last)
        }
        ans = maxOf(ans, index - last + 1)
        map[c] = index + 1
    }
    return ans
}