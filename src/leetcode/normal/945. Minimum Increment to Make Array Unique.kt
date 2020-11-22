package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution945()
//    s.minIncrementForUnique(intArrayOf(1, 2, 2)).print()
//    s.minIncrementForUnique(intArrayOf(3, 2, 1, 2, 1, 7)).print()
    s.minIncrementForUnique(intArrayOf(7, 2, 7, 2, 1, 4, 3, 1, 4, 8)).print()
}

class Solution945 {
    fun minIncrementForUnique(A: IntArray): Int {
        var ans = 0
        val a = IntArray(80000) { 0 }
        A.forEach {
            a[it]++
        }
        for (i in a.indices) {
            if (a[i] > 1) {
                ans += a[i] - 1
                a[i + 1] = a[i + 1] + a[i] - 1
            }
        }
        return ans
    }

}