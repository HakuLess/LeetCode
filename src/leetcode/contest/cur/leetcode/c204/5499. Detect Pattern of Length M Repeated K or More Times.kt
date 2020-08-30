package leetcode.contest.cur.leetcode.c204

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5499()
    s.containsPattern(intArrayOf(1, 2, 3, 1, 2), 2, 2).print()
//    s.containsPattern(intArrayOf(1, 2, 4, 4, 4, 4), 1, 3).print()
//    s.containsPattern(intArrayOf(1, 2, 1, 2, 1, 1, 1, 3), 2, 2).print()
    s.containsPattern(intArrayOf(2, 2), 1, 2).print()
}

class Solution5499 {
    fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
        val n: Int = arr.size
        var i = 0
        while (i + m * k <= n) {
            var check = true
            for (j in i + m until i + m * k) {
                if (arr[j] != arr[j - m]) {
                    check = false
                    break
                }
            }
            if (check) {
                return true
            }
            ++i
        }
        return false
    }
}