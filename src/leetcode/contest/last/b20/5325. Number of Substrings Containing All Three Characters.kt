package leetcode.contest.last.b20

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5325()
    s.numberOfSubstrings("abcabc").print()
    s.numberOfSubstrings("abc").print()
    s.numberOfSubstrings("aaacb").print()
}

class Solution5325 {
    fun numberOfSubstrings(s: String): Int {
        val cur = intArrayOf(0, 0, 0)
        var left = 0
        var right = 0
        var ans = 0
        while (left != s.lastIndex) {
            if (cur[0] > 0 && cur[1] > 0 && cur[2] > 0) {
                ans += s.lastIndex - right + 2
                cur[s[left]- 'a'] = cur[s[left] - 'a'] - 1
                left++
            } else {
                if (right > s.lastIndex) {
                    return ans
                }
                cur[s[right] - 'a'] = cur[s[right] - 'a'] + 1
                right++
            }
        }
        return ans
    }
}