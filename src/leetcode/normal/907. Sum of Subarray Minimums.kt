package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution907()
    s.sumSubarrayMins(intArrayOf(3, 1, 2, 4)).print()
}

class Solution907 {
    fun sumSubarrayMins(A: IntArray): Int {
        val mod = 1_000_000_007
        var ans = 0L
        A.forEachIndexed { index, i ->
            var left = index
            while (left > 0) {
                left--
                if (A[left] < i) {
                    left++
                    break
                }
            }

            var right = index
            while (right < A.lastIndex) {
                right++
                if (A[right] <= i) {
                    right--
                    break
                }
            }

            ans += (((index - left + 1) % mod) * (right - index + 1) % mod) * i % mod
            ans %= mod

            println("$index $i : $left $right")
        }
        return ans.toInt()
    }
}