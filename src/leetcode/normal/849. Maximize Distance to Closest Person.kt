package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution849()
//    s.maxDistToClosest(intArrayOf(1, 0, 0, 0, 1, 0, 1)).print()
//    s.maxDistToClosest(intArrayOf(1, 0, 0, 0)).print()
    s.maxDistToClosest(intArrayOf(0, 1)).print()
}

class Solution849 {
    fun maxDistToClosest(seats: IntArray): Int {
        val left = IntArray(seats.size)
        val right = IntArray(seats.size)

        var start = Int.MIN_VALUE / 2
        for (i in 0 until seats.size) {
            if (seats[i] == 1) {
                start = i
            }
            left[i] = i - start
        }
        left.print()

        start = Int.MAX_VALUE
        for (i in seats.lastIndex downTo 0) {
            if (seats[i] == 1) {
                start = i
            }
            right[i] = start - i
        }
        right.print()

        var max = 0
        for (i in 0 until seats.size) {
            max = maxOf(max, minOf(left[i], right[i]))
        }
        return max
    }
}