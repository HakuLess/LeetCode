package leetcode.contest.last.c145

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1122()
    s.relativeSortArray(
            intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19),
            intArrayOf(2, 1, 4, 3, 9, 6)
    ).print()
}

class Solution1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        return arr1.sortedWith(
                compareBy({
                    if (arr2.indexOf(it) == -1) {
                        Int.MAX_VALUE
                    } else {
                        arr2.indexOf(it)
                    }
                }, { it })
        ).toIntArray()
    }
}