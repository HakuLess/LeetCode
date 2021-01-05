package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution830()
//    s.largeGroupPositions("abcdddeeeeaabbbcd").print()
    s.largeGroupPositions("aaa").print()
}

class Solution830 {
    fun largeGroupPositions(s: String): List<List<Int>> {
        val ans = arrayListOf<ArrayList<Int>>()
        var start = 0
        for (i in 1 until s.length) {
            if (s[i] == s[start]) {
                if (i == s.lastIndex) {
                    ans.add(arrayListOf(start, i))
                }
            } else {
                ans.add(arrayListOf(start, i - 1))
                start = i
            }
        }
        return ans.filter {
            it[1] - it[0] >= 2
        }
    }
}