package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution995()
    s.minKBitFlips(intArrayOf(0, 1, 0), 1).print()
}

class Solution995 {
    fun minKBitFlips(A: IntArray, K: Int): Int {
        val n: Int = A.size
        val diff = IntArray(n + 1)
        var ans = 0
        var revCnt = 0
        for (i in 0 until n) {
            revCnt += diff[i]
            if ((A[i] + revCnt) % 2 == 0) {
                if (i + K > n) {
                    return -1
                }
                ++ans
                ++revCnt
                --diff[i + K]
            }
        }
        return ans
    }
}