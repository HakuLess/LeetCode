package leetcode.contest.last.b18

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5151()
    s.breakPalindrome("").print()
}

class Solution5151 {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length <= 1) {
            return ""
        }
        val index = palindrome.indexOfFirst {
            it != 'a'
        }
        val s = palindrome.toCharArray()
        if (index < 0) {
            s[s.lastIndex] = 'b'
        } else if (index == s.size / 2 && s.size % 2 != 0) {
            s[s.lastIndex] = 'b'
        } else {
            s[index] = 'a'
        }
        return s.joinToString("")
    }
}