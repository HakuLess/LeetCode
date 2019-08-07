package leetcode.contest.last.c141

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1089()
    s.duplicateZeros(intArrayOf(1, 0, 2, 3, 0, 4, 5, 0))
    s.duplicateZeros(intArrayOf(1, 2, 3))
    s.duplicateZeros(intArrayOf(1, 5, 2, 0, 6, 8, 0, 6, 0))
    s.duplicateZeros(intArrayOf(0, 0, 0, 0))
}

class Solution1089 {
    fun duplicateZeros(arr: IntArray): Unit {
        val res = IntArray(arr.size)
        var offset = 0
        for (i in 0 until arr.size) {
            if (arr[i] == 0) {
                offset++
                if (i + offset + 1 < arr.size) {
                    res[i + offset + 1] = arr[i]
                }
            }
            if (i + offset < arr.size) {
                res[i + offset] = arr[i]
            }
        }

        for (i in 0 until arr.size) {
            arr[i] = res[i]
        }

        arr.print()
    }
}