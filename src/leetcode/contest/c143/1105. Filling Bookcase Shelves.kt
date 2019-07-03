package leetcode.contest.c143

import leetcode.print

/**
 * tag DP
 * */
fun main(args: Array<String>) {
    val s = Solution1105()
//    s.minHeightShelves(
//            arrayOf(
//                    intArrayOf(1, 1),
//                    intArrayOf(2, 3),
//                    intArrayOf(2, 3),
//                    intArrayOf(1, 1),
//                    intArrayOf(1, 1),
//                    intArrayOf(1, 1),
//                    intArrayOf(1, 2)
//            ), 4
//    ).print()

    s.minHeightShelves(
            arrayOf(
                    intArrayOf(7, 3),
                    intArrayOf(8, 7),
                    intArrayOf(2, 7),
                    intArrayOf(2, 5)
            ), 10
    ).print()
}

class Solution1105 {
    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        val n = books.size
        val height = IntArray(n + 1)
        for (i in 0 until n) {
            var min = Int.MAX_VALUE
            var h = 0
            var w = 0
            for (j in i downTo 0) {
                h = maxOf(h, books[j][1])
                w += books[j][0]
                if (w > shelf_width) break
                min = minOf(min, h + height[j])
            }
            height[i + 1] = min
        }
        return height[n]
    }
}