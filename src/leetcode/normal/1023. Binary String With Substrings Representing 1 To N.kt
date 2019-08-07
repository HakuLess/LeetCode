package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1023()
    s.queryString("0110", 3).print()
    s.queryString("0110", 4).print()
    s.queryString("110101011011000011011111000000", 15).print()
}

class Solution1023 {
    fun queryString(S: String, N: Int): Boolean {
//        for (i in N downTo N / 2) {
        for (i in N downTo 1) {
            val str = Integer.toBinaryString(i)
            if (!S.contains(str)) {
                return false
            }
        }
        return true
    }
}