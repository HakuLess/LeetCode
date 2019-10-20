package leetcode.contest.cur.b11

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5088()
    s.missingNumber(intArrayOf(5, 7, 11, 13)).print()
    s.missingNumber(intArrayOf(15, 13, 12)).print()
}

class Solution5088 {
    fun missingNumber(arr: IntArray): Int {
        return (arr[0] + arr[arr.lastIndex]) * (arr.size + 1) / 2 - arr.sum()
    }
}