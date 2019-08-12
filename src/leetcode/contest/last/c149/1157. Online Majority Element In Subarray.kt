package leetcode.contest.last.c149

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = MajorityChecker(intArrayOf(1, 1, 2, 2, 1, 1))
    s.query(0, 5, 4).print()
    s.query(0, 3, 3).print()
    s.query(2, 3, 2).print()
}

class MajorityChecker(arr: IntArray) {

    val list = arr

    fun query(left: Int, right: Int, threshold: Int): Int {
        val count = IntArray(20001)
        for (i in left..right) {
            count[list[i]]++
            if (count[list[i]] >= threshold) {
                return list[i]
            }
        }
        return -1
    }
}