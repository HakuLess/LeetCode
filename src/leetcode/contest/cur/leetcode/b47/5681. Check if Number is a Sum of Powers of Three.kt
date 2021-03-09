package leetcode.contest.cur.leetcode.b47

import leetcode.contest.utils.print
import leetcode.contest.utils.toAllSubSet

fun main(args: Array<String>) {
    val s = Solution5681()
    s.checkPowersOfThree(91).print()
}
class Solution5681 {
    fun checkPowersOfThree(n: Int): Boolean {
        return "2" !in n.toString(3)
    }

//    fun checkPowersOfThree(n: Int): Boolean {
//        val cur = arrayListOf<Int>()
//        var c = 1
//        for (i in 0 until 14) {
//            cur.add(c)
//            c *= 3
//        }
//        return n in cur.toIntArray().toAllSubSet()
//    }
}