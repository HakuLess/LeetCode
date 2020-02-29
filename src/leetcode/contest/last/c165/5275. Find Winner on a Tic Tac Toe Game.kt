package leetcode.contest.last.c165

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5275()
    s.tictactoe(arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 0),
            intArrayOf(2, 0)
    )).print()
}

class Solution5275 {
    fun tictactoe(moves: Array<IntArray>): String {
        val m = Array(3) { IntArray(3) }
        moves.forEachIndexed { index, it ->
            m[it[0]][it[1]] = index % 2 + 1
        }
        val v = Array(3) { ArrayList<Int>() }
        for (i in 0..2) {
            if (m[i].all { it == 1 }) {
                return "A"
            }
            if (m[i].all { it == 2 }) {
                return "B"
            }
            v[i].add(m[0][i])
            v[i].add(m[1][i])
            v[i].add(m[2][i])
        }

        v.forEach {
            if (it.all { it == 1 }) {
                return "A"
            }
            if (it.all { it == 2 }) {
                return "B"
            }
        }

        if (m[0][0] == m[1][1] && m[0][0] == m[2][2]) {
            if (m[0][0] == 1) {
                return "A"
            } else if (m[0][0] == 2) {
                return "B"
            }
        }

        if (m[2][0] == m[1][1] && m[2][0] == m[0][2]) {
            if (m[1][1] == 1) {
                return "A"
            } else if (m[1][1] == 2) {
                return "B"
            }
        }

        if (m.any { it.contains(0) }) {
            return "Pending"
        }
        return "Draw"
    }
}