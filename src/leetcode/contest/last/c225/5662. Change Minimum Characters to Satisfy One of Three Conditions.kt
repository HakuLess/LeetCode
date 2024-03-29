package leetcode.contest.last.c225

class Solution5662 {
    fun minCharacters(a: String, b: String): Int {
        fun dfs(a: String, b: String): Int {
            var ans = Int.MAX_VALUE
            for (i in 'a'..'y') {
                var diff = 0
                a.forEach {
                    if (it > i) diff++
                }
                b.forEach {
                    if (it <= i) diff++
                }
                ans = minOf(ans, diff)
            }
            return ans
        }
        val n = (a + b).length
        val m = (a + b).groupingBy { it }.eachCount().values.maxOrNull()!!
        return minOf(dfs(a, b), dfs(b, a), n - m)
    }
}