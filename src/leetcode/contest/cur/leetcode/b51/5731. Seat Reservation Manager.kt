package leetcode.contest.cur.leetcode.b51

import leetcode.contest.utils.MultiSet

class SeatManager(n: Int) {

    val set = MultiSet<Int>()

    init {
        for (i in 1..n) {
            set.add(i)
        }
    }

    fun reserve(): Int {
        return set.popLeft()
    }

    fun unreserve(seatNumber: Int) {
        set.add(seatNumber)
    }

}

/**
 * Your SeatManager object will be instantiated and called as such:
 * var obj = SeatManager(n)
 * var param_1 = obj.reserve()
 * obj.unreserve(seatNumber)
 */