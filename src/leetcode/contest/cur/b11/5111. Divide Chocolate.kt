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
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
//            println("$left, $right, $mid")
            when {
                checkMid(mid, sweetness, K) -> right = mid
                else -> left = mid
            }
        }

        return if (checkMid(left, sweetness, K)) {
            right
        } else {
            left
        }
    }

    private fun checkMid(mid: Int, sweetness: IntArray, K: Int): Boolean {
        var sum = 0
        var c = 0
        for (i in sweetness.indices) {
            sum += sweetness[i]
            if (sum >= mid) {
                c++
                sum = 0
            }
        }
        return c < K + 1
    }

}