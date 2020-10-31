package leetcode.contest.last.c184

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5380()
    s.stringMatching(arrayOf("mass", "as", "hero", "superhero")).forEach {
        it.print()
    }
}

class Solution5380 {
    fun stringMatching(words: Array<String>): List<String> {
        return words.filter { str ->
            words.any {
                it.contains(str) && it != str
            }
        }
    }
}