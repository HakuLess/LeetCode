package leetcode

fun main(args: Array<String>) {
    val s = Solution1004()
    s.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2).print()
    s.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3).print()
}

class Solution1004 {
    fun longestOnes(A: IntArray, K: Int): Int {

        var ans = 0
        var start = 0
        var skip = 0
        for (i in 0 until A.size) {
            if (A[i] == 0) {
                skip++
            }
            if (skip > K) {
                while (A[start] != 0) {
                    start++
                }
                start++
                skip--
            }

            ans = maxOf(ans, i - start + 1)
        }

        return ans
    }
}