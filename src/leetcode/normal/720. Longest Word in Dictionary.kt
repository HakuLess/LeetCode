package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution720()
    s.longestWord(arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple")).print()
    s.longestWord(arrayOf("d", "do", "dog", "p", "pe", "pen", "peng", "pengu", "pengui", "penguin", "e", "el", "ele", "elep", "eleph", "elepha", "elephan", "elephant")).print()
    s.longestWord(arrayOf("w", "wo", "wor", "worl", "world")).print()
}

class Solution720 {
    fun longestWord(words: Array<String>): String {
        var ans = 0
        var res = ""
        val set = HashSet<String>()
        words.sortWith(compareBy({ it.length }, { it }))
        for (i in words.indices) {
            if (words[i].length == 1) {
                set.add(words[i])
                if (words[i].length > ans) {
                    ans = 1
                    res = words[i]
                }
            } else {
                if (words[i].substring(0, words[i].lastIndex) in set) {
                    set.add(words[i])
                    if (words[i].length > ans) {
                        ans = words[i].length
                        res = words[i]
                    }
                }
            }
        }
        return res
    }
}