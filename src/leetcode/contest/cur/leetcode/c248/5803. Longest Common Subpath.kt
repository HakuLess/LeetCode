package leetcode.contest.cur.leetcode.c248

import leetcode.contest.utils.*

fun main(args: Array<String>) {
    val s = Solution5803()
    s.longestCommonSubpath(5, "[[0,1,2,3,4],[2,3,4],[4,0,1,2,3]]".toGrid()).print()
}

// todo
class Solution5803 {
    // TODO 后缀数组解法

    // HashCode
    fun longestCommonSubpath(n: Int, paths: Array<IntArray>): Int {
        fun check(k: Int): Boolean {
            val base = 97755331L
            val mod = 2112291799028938709L
            val multi = quickPower(base, (k - 1).toLong(), mod)
            val map = HashMap<Long, Int>()
            for (path in paths) {
                var cur = 0L
                val seen = hashSetOf<Long>()
                for (i in 0 until k) {
                    cur = (cur * base + path[i]) % mod
                    seen.add(cur)
                }
                map[cur] = map.getOrDefault(cur, 0) + 1
                for (i in k until path.size) {
                    cur = ((cur - path[i - k] * multi) * base + path[i]) % mod
                    if (cur !in seen) {
                        map[cur] = map.getOrDefault(cur, 0) + 1
                        seen.add(cur)
                    }
                }
            }
            return map.values.max()!! == paths.size
        }

        var left = 0
        var right = paths.map { it.size }.min()!!
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                check(mid) -> left = mid
                else -> right = mid
            }
        }
        return if (check(right))
            right
        else left
    }
}