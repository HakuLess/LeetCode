package leetcode.normal

import leetcode.print

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
        var lower = false
        for (i in 0 until word.length) {
            if (i == 0) {
                if (word[i].isLowerCase()) {
                    lower = true
                }
            } else if (i == 1) {
                if (word[i].isLowerCase()) {
                    lower = true
                } else {
                    if (lower) {
                        return false
                    }
                }
            } else {
                if (lower) {
                    if (word[i].isUpperCase()) {
                        return false
                    }
                } else {
                    if (word[i].isLowerCase()) {
                        return false
                    }
                }
            }
        }
        return true
    }
}