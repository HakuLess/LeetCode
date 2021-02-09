package leetcode.contest.last.c146

class Solution5133 {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        var ans = 0
        for ((dx, dy) in arrayOf(Pair(1, 1), Pair(-1, 1), Pair(1, -1), Pair(-1, -1))) {
            var max = Int.MIN_VALUE
            var min = Int.MAX_VALUE
            for (i in arr1.indices) {
                max = maxOf(max, arr1[i] * dx + arr2[i] * dy + i)
                min = minOf(min, arr1[i] * dx + arr2[i] * dy + i)
            }
            ans = maxOf(ans, max - min)
        }
        return ans
    }
}