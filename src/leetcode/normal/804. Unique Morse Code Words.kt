package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution804()
    s.uniqueMorseRepresentations(arrayOf("gin", "zen", "gig", "msg")).print()
}

class Solution804 {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val dic = arrayOf(
            ".-",
            "-...",
            "-.-.",
            "-..",
            ".",
            "..-.",
            "--.",
            "....",
            "..",
            ".---",
            "-.-",
            ".-..",
            "--",
            "-.",
            "---",
            ".--.",
            "--.-",
            ".-.",
            "...",
            "-",
            "..-",
            "...-",
            ".--",
            "-..-",
            "-.--",
            "--.."
        )
        val set = hashSetOf<String>()
        words.forEach {
            set.add(it.map { dic[it - 'a'] }.joinToString(""))
        }
        return set.size
    }
}