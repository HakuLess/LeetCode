package leetcode.contest.last.c144

class Solution1109 {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val res = IntArray(n)
        bookings.forEach {
            for (i in it[0] - 1 until it[1]) {
                res[i] += it[2]
            }
        }
        return res
    }
}