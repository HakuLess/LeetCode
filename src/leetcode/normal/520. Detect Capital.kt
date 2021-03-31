package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution520()
    s.detectCapitalUse("USA").print()
    s.detectCapitalUse("FlaG").print()
    s.detectCapitalUse("leetcode").print()
    s.detectCapitalUse("Leetcode").print()
    s.detectCapitalUse("mL").print()
}

class Solution520 {
    fun detectCapitalUse(word: String): Boolean {
        if (word.length <= 1) return true
        val c = word[1].isLowerCase() || word[0].isLowerCase()
        return (1..word.lastIndex).all {
            word[it].isLowerCase() == c
        }
    }
}