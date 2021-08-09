package leetcode.normal

import leetcode.contest.utils.print
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution46()
    s.permute(intArrayOf(1, 1, 2)).print()
}

class Solution46 {

    val ans = ArrayList<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        backtrack(nums, arrayListOf())
        return ans
    }

    private fun backtrack(nums: IntArray, tracker: ArrayList<Int>) {
        if (tracker.size == nums.size) {
            ans.add(ArrayList(tracker))
            return
        }
        for (num in nums) {
            if (tracker.contains(num)) {
                continue
            }
            tracker.add(num)
            backtrack(nums, tracker)
            tracker.remove(num)
        }
    }
}