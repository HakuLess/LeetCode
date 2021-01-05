package leetcode.contest.last.c162

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5258()
    s.maxScoreWords(
            arrayOf("dog", "cat", "dad", "good"),
//            arrayOf("dad", "good"),
            charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
            intArrayOf(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).print()
}

class Solution5258 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val n = words.size
        val total = IntArray(26)
        letters.forEach {
            total[it - 'a']++
        }
        val t = IntArray(26) { i -> i }
        var ans = 0
        for (i in 0 until (1 shl n)) {
            val cur = IntArray(26)
            for (j in 0 until n) {
                if (i and (1 shl j) != 0) {
                    words[j].forEach {
                        cur[it - 'a']++
                    }
                }
            }
            if (t.all { cur[it] <= total[it] }) {
                var c = 0
                t.forEach {
                    c += score[it] * cur[it]
                }
                ans = maxOf(ans, c)
            }
        }
        return ans
    }
}