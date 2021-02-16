package leetcode.contest.cur.leetcode.c228

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5678()
    s.minimumSize(intArrayOf(2, 4, 8, 2), 4).print()
}

class Solution5678 {
    fun minimumSize(nums: IntArray, maxOperations: Int): Int {
        fun check(mid: Int): Boolean {
            var ans = 0
            nums.forEach {
                if (it > mid) {
                    ans += (it - 1) / mid
                }
            }
            return ans <= maxOperations
        }

        var left = 1
        var right = nums.max()!!
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                check(mid) -> right = mid
                else -> left = mid
            }
        }
        return if (check(left)) {
            left
        } else {
            right
        }
    }
}