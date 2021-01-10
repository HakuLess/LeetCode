package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution47()
    s.permuteUnique(intArrayOf(1, 2, 3, 2)).print()
}

class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val ans: MutableList<List<Int>> = ArrayList()
        val perm: MutableList<Int> = ArrayList()
        val vis = BooleanArray(nums.size)
        nums.sort()

        fun backtrack(nums: IntArray, ans: MutableList<List<Int>>, idx: Int, perm: MutableList<Int>) {
            if (idx == nums.size) {
                ans.add(ArrayList(perm))
                return
            }
            for (i in nums.indices) {
                if (vis[i] || i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                    continue
                }
                perm.add(nums[i])
                vis[i] = true
                backtrack(nums, ans, idx + 1, perm)
                vis[i] = false
                perm.removeAt(idx)
            }
        }

        backtrack(nums, ans, 0, perm)
        return ans
    }
}