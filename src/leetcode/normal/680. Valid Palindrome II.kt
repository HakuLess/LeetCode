package leetcode.normal

class Solution680 {

    // one chance to remove one char
    var used = false

    fun validPalindrome(s: String): Boolean {
        println(s)
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
                    validPalindrome(s.substring(left + 1, right)) ||
                            validPalindrome(s.substring(left, right - 1))
                }
            }
        }

        return true
    }
}