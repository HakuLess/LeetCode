package leetcode.contest.cur.leetcode.c207

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5520()
    s.maxUniqueSplit("ababccc").print()
//    s.maxUniqueSplit("aba").print()
}

class Solution5520 {
    fun maxUniqueSplit(s: String): Int {
        var ans = 0
        fun dfs(s: String, seen: HashSet<String>) {
            if (s.isEmpty()) {
                ans = maxOf(ans, seen.size)
                println(seen.joinToString(","))
                return
            }
            for (i in 1..s.length) {
                val sub = s.substring(IntRange(i, s.lastIndex))
                val remove = s.substring(IntRange(0, i - 1))
                println("split $remove $sub")
                if (remove in seen) {
                    continue
                }
                seen.add(remove)
                dfs(sub, seen)
                seen.remove(remove)
            }
        }
        dfs(s, hashSetOf())
        return ans
    }
}