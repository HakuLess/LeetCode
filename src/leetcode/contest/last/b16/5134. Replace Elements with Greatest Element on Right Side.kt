package leetcode.contest.last.b16

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5134()
    s.replaceElements(intArrayOf(17, 18, 5, 4, 6, 1)).print()
}

class Solution5134 {
    fun replaceElements(arr: IntArray): IntArray {
        var max = -1
        for (i in arr.indices.reversed()) {
            val temp = arr[i]
            arr[i] = max
            max = maxOf(temp, max)
        }
        return arr
    }
}