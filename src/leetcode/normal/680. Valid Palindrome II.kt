package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution680()
//    s.validPalindrome("abc").print()
//    s.validPalindrome("aba").print()
    s.validPalindrome("abca").print()
}

class Solution680 {

    // one chance to remove one char
    var used = false

    fun validPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            if (s[left] == s[right]) {
                left++
                right--
            } else {
                return if (used) {
                    false
                } else {
                    used = true
                    validPalindrome(s.substring(left + 1, right + 1)) ||
                            validPalindrome(s.substring(left, right))
                }
            }
        }
        return true
    }
}