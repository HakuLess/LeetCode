package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution978()
    s.maxTurbulenceSize(intArrayOf(9, 4, 2, 10, 7, 8, 8, 1, 9)).print()
    s.maxTurbulenceSize(intArrayOf(1, 2, 3, 4)).print()
    s.maxTurbulenceSize(intArrayOf(9)).print()
}

class Solution978 {

    fun maxTurbulenceSize(A: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }
        var pre = A[0]
        var max = 1

        var larger: Boolean? = null
        var cur = 1

        for (i in 1 until A.size) {
            when {
                A[i] > pre -> {
                    when {
                        larger == null -> cur++
                        larger -> cur = 2
                        else -> cur++
                    }
                    larger = true
                }
                A[i] < pre -> {
                    when {
                        larger == null -> cur++
                        !larger -> cur = 2
                        else -> cur++
                    }
                    larger = false
                }
                else -> {
                    larger = null
                    cur = 1
                }
            }

            pre = A[i]
            max = maxOf(max, cur)

//            println("${A[i]}, $cur")
        }

        return max
    }
}