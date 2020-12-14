package leetcode.contest.cur.leetcode.c219

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5245()
    s.maxHeight(
            arrayOf(
                    intArrayOf(50, 45, 20),
                    intArrayOf(95, 37, 53),
                    intArrayOf(45, 23, 12)
            )
    ).print()

    s.maxHeight(
            arrayOf(
                    intArrayOf(92, 47, 83),
                    intArrayOf(75, 20, 87),
                    intArrayOf(68, 12, 83),
                    intArrayOf(12, 85, 15),
                    intArrayOf(16, 24, 47),
                    intArrayOf(69, 65, 35),
                    intArrayOf(96, 56, 93),
                    intArrayOf(89, 93, 11),
                    intArrayOf(86, 20, 41),
                    intArrayOf(69, 77, 12),
                    intArrayOf(83, 80, 97),
                    intArrayOf(90, 22, 36)
            )
    ).print()
}

class Solution5245 {
    fun maxHeight(cuboids: Array<IntArray>): Int {
        cuboids.forEach {
            it.sort()
        }
        val list = cuboids.sortedWith(compareBy({ it[0] }, { it[1] }, { it[2] }))
        val seen = HashMap<String, Int>()
        fun dfs(index: Int, w: Int, l: Int, h: Int): Int {
            val key = "$index,$w,$l,$h"
            if (key in seen) {
                return seen[key]!!
            }
            if (index !in list.indices) return 0
            val cur = list[index]
            var ans = 0
            if (cur[0] >= w && cur[1] >= l && cur[2] >= h) {
                ans = maxOf(ans, dfs(index + 1, cur[0], cur[1], cur[2]) + cur[2])
            }
            ans = maxOf(ans, dfs(index + 1, w, l, h))
            return ans.also {
                seen[key] = it
            }
        }
        return dfs(0, 0, 0, 0)
    }
}