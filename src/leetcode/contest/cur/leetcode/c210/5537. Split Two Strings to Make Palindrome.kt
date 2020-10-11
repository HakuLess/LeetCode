package leetcode.contest.cur.leetcode.c210

class Solution5537 {
    fun checkPalindromeFormation(a: String, b: String): Boolean {
        fun isPalindrome(x: String): Boolean {
            val s = x.toString()
            return s == s.reversed()
        }
        fun dfs(x: String, y: String): Boolean {
            for (i in x.indices) {
                if (x[i] == y[y.length - 1 - i]) continue
                else {
                    return isPalindrome(y.substring(i, y.length - i)) || isPalindrome(x.substring(i, x.length - i))
                }
            }
            return true
        }
        if (isPalindrome(a) || isPalindrome(b)) {
            return true
        }
        if (dfs(a, b) || dfs(b, a)) {
            return true
        }
        return false
    }
}