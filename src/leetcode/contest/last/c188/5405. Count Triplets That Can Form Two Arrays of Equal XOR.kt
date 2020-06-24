package leetcode.contest.last.c188

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5405()
    s.countTriplets(intArrayOf(2, 3, 1, 6, 7)).print()
    s.countTriplets(intArrayOf(1, 1, 1, 1, 1)).print()
    s.countTriplets(intArrayOf(2, 3)).print()
    s.countTriplets(intArrayOf(1, 3, 5, 7, 9)).print()
    s.countTriplets(intArrayOf(7, 11, 12, 9, 5, 2, 7, 17, 22)).print()
}

class Solution5405 {
    fun countTriplets(arr: IntArray): Int {
        var ans = 0
        for (i in 0 until arr.size - 1) {
            for (k in i + 1 until arr.size) {
                var cur = 0
                for (c in i..k) {
                    cur = cur xor arr[c]
                }
                if (cur == 0) {
                    ans += k - i
                }
            }
        }
        return ans
    }
}