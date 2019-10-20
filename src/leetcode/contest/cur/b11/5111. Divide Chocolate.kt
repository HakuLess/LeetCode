package leetcode.contest.cur.b11

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5111()
    s.maximizeSweetness(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5).print()
    s.maximizeSweetness(intArrayOf(5, 6, 7, 8, 9, 1, 2, 3, 4), 8).print()
    s.maximizeSweetness(intArrayOf(1, 2, 2, 1, 2, 2, 1, 2, 2), 2).print()
}

class Solution5111 {
    fun maximizeSweetness(sweetness: IntArray, K: Int): Int {
        var left = sweetness.min()!!
        var right = sweetness.sum()
        while (left < right) {
            val mid = (left + right + 1).ushr(1)
            if (split(sweetness, mid) < K + 1) {
                right = mid - 1
            } else {
                left = mid
            }
        }
        return left
    }

    private fun split(arr: IntArray, minSweetness: Int): Int {
        var peopleCount = 0
        var sweetness = 0
        for (`val` in arr) {
            sweetness += `val`
            if (sweetness >= minSweetness) {
                peopleCount++
                sweetness = 0
            }
        }
        return peopleCount
    }
}