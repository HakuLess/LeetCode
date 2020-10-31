package leetcode.contest.cur.leetcode.b38

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5542()
    s.numWays(arrayOf("acca", "bbbb", "caca"), "aba").print()
}

class Solution5542 {
    fun numWays(words: Array<String>, target: String): Int {
        val mod = 1000000007L

        val memo = HashMap<Pair<Int, Int>, Long>()
        val array = Array<IntArray>(26) { IntArray(words[0].length) }
        words.forEachIndexed { _, s ->
            for (i in s.indices) {
                array[s[i] - 'a'][i]++
            }
        }

        fun dfs(i: Int, j: Int): Long {
            val key = Pair(i, j)
            if (key in memo) return memo[key]!!
            if (i > target.lastIndex) return 1L
            if (j > words[0].lastIndex) return 0L
            var ans = 0L
            if (array[target[i] - 'a'][j] != 0) {
                ans += array[target[i] - 'a'][j] * dfs(i + 1, j + 1)
            }
//            if (words.any { it[j] == target[i] }) {
//                ans += words.count { it[j] == target[i] } * dfs(i + 1, j + 1)
//            }
            ans += dfs(i, j + 1)
            ans %= mod
            return ans.also {
                memo[key] = it
            }
        }
        return (dfs(0, 0) % mod).toInt()
    }
}