package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution830()
//    s.largeGroupPositions("abcdddeeeeaabbbcd").print()
    s.largeGroupPositions("aaa").print()
}

class Solution830 {
    fun largeGroupPositions(S: String): List<List<Int>> {

        val ans = arrayListOf<ArrayList<Int>>()
        var start = 0
        for (i in 1 until S.length) {
            if (S[i] == S[start]) {
                if (i == S.length - 1) {
                    ans.add(arrayListOf(start, i))
                }
                continue
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