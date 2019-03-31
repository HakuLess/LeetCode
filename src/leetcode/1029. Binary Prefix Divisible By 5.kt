package leetcode

fun main(args: Array<String>) {
    val s = Solution1029()
    s.prefixesDivBy5(intArrayOf(0, 1, 1)).print()
    s.prefixesDivBy5(intArrayOf(1, 1, 1)).print()
    s.prefixesDivBy5(intArrayOf(0, 1, 1, 1, 1, 1)).print()
    s.prefixesDivBy5(intArrayOf(1, 1, 1, 0, 1)).print()
    s.prefixesDivBy5(intArrayOf(1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1)).print()
}

class Solution1029 {
    fun prefixesDivBy5(A: IntArray): BooleanArray {
        val ans = arrayListOf<Boolean>()
        var cur = 0
        for (i in 0 until A.size) {
            cur *= 2
            cur %= 5
            cur += A[i]
            ans.add(cur % 5 == 0)
        }
        return ans.toBooleanArray()
    }
}