package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution72()
    s.minDistance("horse", "ros").print()
    s.minDistance("intention", "execution").print()
}

class Solution72 {
    fun minDistance(word1: String, word2: String): Int {
        val seen = HashMap<Pair<Int, Int>, Int>()
        fun dfs(i: Int, j: Int): Int {
            val key = Pair(i, j)
            if (key in seen) {
                return seen[key]!!
            }
            if (i == word1.length) return word2.length - j
            if (j == word2.length) return word1.length - i
            if (word1[i] == word2[j]) {
                return dfs(i + 1, j + 1).also {
                    seen[key] == it
                }
            }
            return minOf(minOf(dfs(i + 1, j) + 1, dfs(i, j + 1) + 1), dfs(i + 1, j + 1) + 1)
                    .also { seen[key] = it }
        }
        return dfs(0, 0)
    }
}