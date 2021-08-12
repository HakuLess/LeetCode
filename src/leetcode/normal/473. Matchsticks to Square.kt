package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution473()
    s.makesquare(intArrayOf(5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3)).print()
    s.makesquare(intArrayOf(1, 1, 2, 2, 2)).print()
}

class Solution473 {
    fun makesquare(nums: IntArray): Boolean {
        if (nums.size < 4) return false
        val sum = nums.sum()
        if (sum % 4 != 0) return false
        if (nums.maxOrNull()!! > sum / 4) return false

        val n = nums.size
        val arr = IntArray(1 shl n)
        for (i in 0 until (1 shl n)) {
            for (j in 0 until n) {
                if (i and (1 shl j) != 0) {
                    arr[i] += nums[j]
                }
            }
        }

        val seen = HashMap<String, Boolean>()
        seen["0,0"] = true
        fun dfs(state: Int, left: Int): Boolean {
            val key = "$state,$left"
            if (key in seen) return seen[key]!!
            var cur = state
            while (cur != 0) {
                if (arr[cur] == sum / 4) {
                    if (dfs(state - cur, left - 1))
                        return true.also {
                            seen[key] = it
                        }
                }
                cur = (cur - 1) and state
            }
            return false.also { seen[key] = it }
        }
        return dfs((1 shl n) - 1, 4)
    }
}