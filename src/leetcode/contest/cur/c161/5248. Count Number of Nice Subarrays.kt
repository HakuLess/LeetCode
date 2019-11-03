package leetcode.contest.cur.c161

import leetcode.contest.utils.print
import java.util.ArrayList

fun main(args: Array<String>) {
    val s = Solution5248()
    s.numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3).print()
    s.numberOfSubarrays(intArrayOf(2, 4, 6), 1).print()
    s.numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2).print()
    s.numberOfSubarrays(intArrayOf(1, 1, 1, 1, 1), 1).print()
}

class Solution5248 {

    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val pos = ArrayList<Int>()
        val n = nums.size
        pos.add(-1)

        var ans = 0
        for (i in 0 until n) {
            if (nums[i] % 2 == 1)
                pos.add(i)
            if (pos.size > k) {
                ans += pos[pos.size - k] - pos[pos.size - k - 1]
            }
        }
        return ans
    }
}