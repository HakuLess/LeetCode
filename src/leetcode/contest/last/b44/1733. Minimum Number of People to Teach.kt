package leetcode.contest.last.b44

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution1733()
    s.minimumTeachings(3, "[[2],[1,3],[1,2],[3]]".toGrid(), "[[1,4],[1,2],[3,4],[2,3]]".toGrid()).print()
}

class Solution1733 {
    fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
        val study = hashSetOf<Int>()
        friendships.forEach { (a, b) ->
            if (languages[a - 1].all { it !in languages[b - 1] }) {
                study.add(a - 1)
                study.add(b - 1)
            }
        }
        val arr = IntArray(500)
        study.forEach {
            languages[it].forEach {
                arr[it]++
            }
        }
        return study.size - arr.maxOrNull()!!
    }
}