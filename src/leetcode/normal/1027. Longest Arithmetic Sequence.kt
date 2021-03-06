package leetcode.normal

import leetcode.contest.utils.print
import java.util.HashMap


fun main(args: Array<String>) {
    val s = Solution1027()
    s.longestArithSeqLength(intArrayOf(20, 1, 15, 3, 10, 5, 8)).print()
}

class Solution1027 {

    fun longestArithSeqLength(A: IntArray): Int {
        var max = 0
        val list = Array<HashMap<Int, Int>>(A.size) { hashMapOf() }

        for (i in 1 until A.size) {
            for (j in 0 until i) {
                // list end with index, difference is A[i] - A[j]
                val prev = list[j].getOrDefault(A[i] - A[j], 1)
                list[i][A[i] - A[j]] = prev + 1
                max = maxOf(prev + 1, max)
            }
        }
        return max
    }
}