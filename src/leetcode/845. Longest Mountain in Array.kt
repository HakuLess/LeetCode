package leetcode

class Solution845 {
    fun longestMountain(A: IntArray): Int {
        var start = 0
        var max = 1
        var before: Boolean? = null
        for (i in 1 until A.size) {
            when {
                A[i] > A[i - 1] -> {
                    if (before == null || !before) {
                        start = i - 1
                        before = true
                    }
//                    println("a: $i $start")
//                    max = maxOf(max, i - start + 1)
                }
                A[i] == A[i - 1] -> {
                    before = null
                    start = i
                }
                else -> {
                    if (before != null) {
                        if (before) {
                            before = false
                        }
                        println("b: $i $start")
                        max = maxOf(max, i - start + 1)
                    }
                }
            }
        }
        return max
    }
}