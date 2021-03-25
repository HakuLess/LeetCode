package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution893()
    s.numSpecialEquivGroups(arrayOf("abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx")).print()
}

class Solution893 {
    fun numSpecialEquivGroups(A: Array<String>): Int {
        return A.map {
            val first = IntArray(26)
            val second = IntArray(26)
            it.forEachIndexed { index, c ->
                if (index % 2 == 0)
                    first[c - 'a']++
                else
                    second[c - 'a']++
            }
            first.joinToString(",") + second.joinToString(",")
        }.toSet().size
    }
}