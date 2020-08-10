package leetcode.contest.cur.leetcode.c201

class Solution5486 {
    fun minCost(n: Int, cuts: IntArray): Int {
        val seen = HashMap<Pair<Int, Int>, Int>()
        fun dfs(i: Int, j: Int): Int {
            if (Pair(i, j) in seen) {
                return seen[Pair(i, j)]!!
            }
            var ans = Int.MAX_VALUE
            cuts.forEach {
                if (it in (i + 1) until j) {
                    ans = minOf(ans, dfs(i, it) + dfs(it, j) + j - i)
                }
            }
            if (ans == Int.MAX_VALUE) {
                return 0.also { seen[Pair(i, j)] = it }
            }
            return ans.also { seen[Pair(i, j)] = it }
        }

        return dfs(0, n)
    }
}