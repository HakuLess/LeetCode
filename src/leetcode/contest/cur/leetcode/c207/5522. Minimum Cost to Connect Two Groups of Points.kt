package leetcode.contest.cur.leetcode.c207

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5522()
    s.connectTwoGroups(listOf(
            listOf(15, 96),
            listOf(36, 2)
    )).print()

    s.connectTwoGroups(listOf(
            listOf(1, 3, 5),
            listOf(4, 1, 1),
            listOf(1, 5, 3)
    )).print()

    s.connectTwoGroups(listOf(
            listOf(2, 5, 1),
            listOf(3, 4, 7),
            listOf(8, 1, 2),
            listOf(6, 2, 4),
            listOf(3, 8, 8)
    )).print()
}

class Solution5522 {
    fun connectTwoGroups(cost: List<List<Int>>): Int {
        val map = HashMap<Pair<Int, Int>, Int>()
        val n = cost.size
        val m = cost[0].size

        for (i in cost.indices) {
            for (j in cost[0].indices) {
                map[Pair(i, j)] = cost[i][j]
            }
        }

        val memo = HashMap<String, Int>()
        fun dfs(seen: HashSet<Int>, cur: Int): Int {
            if (cur == m + n) return 0
            val list = arrayListOf<Int>()
            list.addAll(seen)
            val key = list.sorted().joinToString(", ")
            if (key in memo) return memo[key]!!

            var ans = Int.MAX_VALUE
            val left = cur < n
            if (cur in seen) {
                ans = dfs(seen, cur + 1)
            } else {
                seen.add(cur)
                if (left) {
                    for (i in 0 until m) {
                        val clone = HashSet(seen)
                        clone.add(i + n)
                        ans = minOf(ans, map[Pair(cur, i)]!! + dfs(clone, cur + 1))
                    }
                } else {
                    for (i in 0 until n) {
                        val clone = HashSet(seen)
                        clone.add(i)
                        ans = minOf(ans, map[Pair(i, cur - n)]!! + dfs(clone, cur + 1))
                    }
                }
            }
            return ans.also {
                memo[key] = it
            }
        }
        return dfs(hashSetOf(), 0)
    }
}