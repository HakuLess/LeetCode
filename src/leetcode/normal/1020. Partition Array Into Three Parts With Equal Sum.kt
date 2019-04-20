package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1020()
    s.canThreePartsEqualSum(
            intArrayOf(0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1)
    ).print()
    s.canThreePartsEqualSum(
            intArrayOf(0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1)
    ).print()
    s.canThreePartsEqualSum(
            intArrayOf(3, 3, 6, 5, -2, 2, 5, 1, -9, 4)
    ).print()
}

class Solution1020 {
    fun canThreePartsEqualSum(A: IntArray): Boolean {
        var sum = A.sum()
        if (sum % 3 != 0) {
            return false
        }
        sum /= 3
//        sum.print()
        var ans = 0
        var times = 0
        for (i in 0 until A.size) {
            ans += A[i]
            if (ans == sum) {
                ans = 0
                times++
            }
        }
//        println(times)
        return (times == 3) && (ans == 0)
    }
}