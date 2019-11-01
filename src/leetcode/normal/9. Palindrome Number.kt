package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution9()
//    s.isPalindrome(191).print()
    s.isPalindrome(1000021).print()
}

class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        return s == s.reversed()
    }
}