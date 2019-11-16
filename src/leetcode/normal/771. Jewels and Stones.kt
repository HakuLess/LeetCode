package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
//    val J = "aA"
//    val S = "aAAbbbb"
    val J = "z"
    val S = "ZZ"
    val s = Solution771()
    s.numJewelsInStones(J, S).print()
}

class Solution771 {
    fun numJewelsInStones(J: String, S: String): Int {
        return S.toCharArray().count { it in J.toCharArray() }
    }
}