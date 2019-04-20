package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    findJudge(1, arrayOf()).print()
    findJudge(2, arrayOf(intArrayOf(1, 2))).print()
    findJudge(3, arrayOf(intArrayOf(1, 3),
            intArrayOf(2, 3))).print()
    findJudge(3, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
    )).print()
    findJudge(3, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
    )).print()
    findJudge(4, arrayOf(
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 4),
            intArrayOf(2, 3),
            intArrayOf(4, 3)
    )).print()
}

fun findJudge(N: Int, trust: Array<IntArray>): Int {
    val ans = IntArray(N + 1)
    trust.forEach {
        ans[it[0]]--
        ans[it[1]]++
    }

    var max = 0
    var pos = 1
    ans.forEachIndexed { index, i ->
        if (i > max) {
            max = i
            pos = index
        }
    }

    return if (max == N - 1) {
        pos
    } else {
        -1
    }
}