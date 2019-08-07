package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution763()
    s.partitionLabels("qiejxqfnqceocmy").forEach {
        print("$it, ")
    }
}

class Solution763 {

    val ans = arrayListOf<Int>()

    fun partitionLabels(S: String): List<Int> {
        part(S)
        return ans
    }

    private fun part(S: String) {
        S.print()
        if (S.isEmpty()) {
            return
        }
        var start = 0
        val c = S[start]
        var end = S.lastIndexOf(c)
        var i = start
        while (i <= end) {
            end = maxOf(end, S.lastIndexOf(S[i]))
            i++
        }
//        for (i in start..end) {
//
//        }

        start = end + 1
        ans.add(start)
        part(S.substring(start))
    }
}