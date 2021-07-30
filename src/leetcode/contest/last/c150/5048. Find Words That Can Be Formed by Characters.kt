package leetcode.contest.last.c150

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5048()
    s.countCharacters(arrayOf("cat", "bt", "hat", "tree"), "atach").print()
}

class Solution5048 {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val c = IntArray(26)
        chars.forEach {
            c[it - 'a']++
        }
        return words.map {
            val cur = IntArray(26)
            it.forEach {
                cur[it - 'a']++
            }
            Pair(cur, it.length)
        }.filter {
            ((0..25).all { index ->
                it.first[index] <= c[index]
            })
        }.sumBy { it.second }
    }
}