package leetcode.contest.cur.leetcode.c230

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5690()
    s.closestCost(intArrayOf(3, 10), intArrayOf(2, 5), 9).print()
}

class Solution5690 {
    fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
        var ans = Int.MAX_VALUE / 2
        fun dfs(cur: Int, index: Int) {
            if (abs(cur - target) < abs(ans - target)) {
                ans = cur
            } else if (abs(cur - target) == abs(ans - target) && cur < ans) {
                ans = cur
            }
            if (index !in toppingCosts.indices) return
            dfs(cur, index + 1)
            dfs(cur + toppingCosts[index], index + 1)
            dfs(cur + toppingCosts[index] * 2, index + 1)
        }
        for (i in baseCosts) {
            dfs(i, 0)
        }
        return ans
    }
}