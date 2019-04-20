package leetcode.normal

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