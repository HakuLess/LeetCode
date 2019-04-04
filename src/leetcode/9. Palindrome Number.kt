package leetcode

fun main(args: Array<String>) {
    val s = Solution9()
//    s.isPalindrome(191).print()
    s.isPalindrome(1000021).print()
}

class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        val s = x.toString()
        return isPalindrome(s)
    }

    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            when {
                !s[left].isLetterOrDigit() ->
                    left++
                !s[right].isLetterOrDigit() ->
                    right--
                s[right].toLowerCase() == s[left].toLowerCase() -> {
                    left++
                    right--
                }
                else -> return false
            }
        }
        return true
    }
}