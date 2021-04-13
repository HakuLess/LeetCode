package leetcode.contest.cur.leetcode.c236

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5727()
    s.findTheWinner(5, 2).print()
    s.findTheWinner(6, 5).print()
}

class Solution5727 {
    fun findTheWinner(n: Int, k: Int): Int {
        var p = 0
        for (i in 2..n) {
            p = (p + k) % i
        }
        return p + 1
    }

//    fun findTheWinner(n: Int, k: Int): Int {
//        val l = ArrayList<Int>()
//        for (i in 1..n) {
//            l.add(i)
//        }
//        var cur = 0
//        while (l.size != 1) {
//            cur = (cur + k - 1) % l.size
//            l.removeAt(cur)
//        }
//        return l.first()
//    }
}