package leetcode.contest.cur.leetcode.c203

class Solution5498 {
    fun stoneGameV(stoneValue: IntArray): Int {
        val p = IntArray(stoneValue.size + 1)
        for (i in stoneValue.indices) {
            p[i + 1] = p[i] + stoneValue[i]
        }

        val seen = HashMap<Pair<Int, Int>, Int>()
        fun dfs(i: Int, j: Int): Int {
            if (i >= j) return 0
            val key = Pair(i, j)
            if (key in seen) {
                return seen[key]!!
            }
            var res = Int.MIN_VALUE
            for (k in i..j) {
                val left = p[k + 1] - p[i]
                val right = p[j + 1] - p[k + 1]
                res = when {
                    left > right -> {
                        maxOf(res, right + dfs(k + 1, j))
                    }
                    left < right -> {
                        maxOf(res, left + dfs(i, k))
                    }
                    else -> {
                        maxOf(res, left + maxOf(dfs(i, k), dfs(k + 1, j)))
                    }
                }
            }
            return res.also {
                seen[key] = it
            }
        }

        return dfs(0, stoneValue.lastIndex)
    }
}