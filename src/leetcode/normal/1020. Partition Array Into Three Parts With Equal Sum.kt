package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1020()
    s.canThreePartsEqualSum(
        intArrayOf(
            3, 3, 6, 5, -2, 2, 5, 1, -9, 4
        )
    ).print()
}

class Solution1020 {
    fun canThreePartsEqualSum(arr: IntArray): Boolean {
        val sum = arr.sum()
        if (sum % 3 != 0) return false
        var cur = 0
        var left = -1
        var right = -1
        for (i in arr.indices) {
            cur += arr[i]
            if (cur == sum / 3) {
                left = i
                break
            }
        }
        cur = 0
        for (i in arr.indices.reversed()) {
            cur += arr[i]
            if (cur == sum / 3) {
                right = i
                break
            }
        }
        return (left != -1 && right != -1 && right > left + 1)
    }
}