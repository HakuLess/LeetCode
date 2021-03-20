package leetcode.contest.cur.leetcode.b48

import leetcode.contest.utils.gcd

class Solution5695 {
    fun maxScore(nums: IntArray): Int {
        val seen = HashMap<String, Int>()
        fun dfs(v: Int, cur: ArrayList<Int>): Int {
            val key = "v,${cur.joinToString(",")}"
            if (key in seen) return seen[key]!!
            var ans = 0
            for (i in 0 until cur.lastIndex) {
                for (j in i + 1 until cur.size) {
                    val c = cur.clone() as ArrayList<Int>
                    c.removeAt(j)
                    c.removeAt(i)
                    ans = maxOf(ans, v * gcd(cur[i], cur[j]) + dfs(v + 1, c))
                }
            }
            return ans.also { seen[key] = it }
        }
        return dfs(1, ArrayList(nums.toList()))
    }
}