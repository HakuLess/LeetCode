package leetcode.contest.cur.leetcode.c229

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5687()
//    s.maximumScore(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)).print()
    s.maximumScore(intArrayOf(-5, -3, -3, -2, 7, 1), intArrayOf(-10, -5, 3, 4, 6)).print()
}

class Solution5687 {
    fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
        val seen = HashMap<String, Int>()
        fun dfs(l: Int, r: Int, i: Int): Int {
            val key = "$l,$r"
            if (key in seen) return seen[key]!!
            if (i !in multipliers.indices) return 0
            val ans = maxOf(nums[l] * multipliers[i] + dfs(l + 1, r, i + 1),
                    nums[r] * multipliers[i] + dfs(l, r - 1, i + 1))
            return ans.also {
                seen[key] = it
            }
        }
        return dfs(0, nums.lastIndex, 0).also {
//            seen.print()
        }
    }
}