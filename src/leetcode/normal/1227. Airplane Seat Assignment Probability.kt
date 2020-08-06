package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1227()
    s.nthPersonGetsNthSeat(1).print()
    s.nthPersonGetsNthSeat(2).print()
    s.nthPersonGetsNthSeat(3).print()
    s.nthPersonGetsNthSeat(4).print()
    s.nthPersonGetsNthSeat(10).print()
}

class Solution1227 {
    fun nthPersonGetsNthSeat(n: Int): Double {
        return if (n == 1) 1.0 else 0.5
    }
//    fun nthPersonGetsNthSeat(n: Int): Double {
//        var sum = 1.0
//        var cur = 1.0
//        for (i in n downTo 2) {
//            sum *= 1.0 / i.toDouble()
//            cur -= sum
//        }
//        return cur
//    }
}