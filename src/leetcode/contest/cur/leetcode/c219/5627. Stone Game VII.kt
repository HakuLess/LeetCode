package leetcode.contest.cur.leetcode.c219

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5627()
    s.stoneGameVII(intArrayOf(5, 3, 1, 4, 2)).print()
    s.stoneGameVII(intArrayOf(7, 90, 5, 1, 100, 10, 10, 2)).print()
}

class Solution5627 {
    fun stoneGameVII(stones: IntArray): Int {
        val pre = IntArray(stones.size)
        for (i in stones.indices) {
            pre[i] = stones[i] + if (i == 0) 0 else pre[i - 1]
        }
        val seen = HashMap<String, Int>()
        fun get(l: Int, r: Int): Int {
            return pre[r] - if (l == 0) 0 else pre[l - 1]
        }

        fun dfs(a: Int, b: Int): Int {
            val key = "$a, $b"
            if (key in seen) {
                return seen[key]!!
            }
            if (a >= b) return 0
            val left = get(a + 1, b) - dfs(a + 1, b)
            val right = get(a, b - 1) - dfs(a, b - 1)
            val ans = maxOf(left, right)
            return ans.also {
                seen[key] = it
            }
        }
        return dfs(0, stones.lastIndex)
    }
}