package leetcode.contest.cur.leetcode.c203

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5495()
//    s.mostVisited(4, intArrayOf(1, 3, 1, 2)).joinToString(" ").print()
//    s.mostVisited(2, intArrayOf(2, 1, 2, 1, 2, 1, 2, 1, 2)).joinToString(" ").print()
//    s.mostVisited(7, intArrayOf(1, 3, 5, 7)).joinToString(" ").print()
    s.mostVisited(3, intArrayOf(3, 2, 1, 2, 1, 3, 2, 1, 2, 1, 3, 2, 3, 1)).joinToString(" ").print()
}

class Solution5495 {
    fun mostVisited(n: Int, rounds: IntArray): List<Int> {
        val start = rounds[0]
        val end = rounds.last()
        val ans = arrayListOf<Int>()
        if (end >= start) {
            for (i in start..end) {
                ans.add(i)
            }
        } else {
            for (i in start..n) {
                ans.add(i)
            }
            for (i in 1..end) {
                ans.add(i)
            }
        }
        return ans.sorted()
    }
}