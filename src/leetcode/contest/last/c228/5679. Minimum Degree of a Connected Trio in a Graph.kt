package leetcode.contest.last.c228

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5679()
    s.minTrioDegree(6, "[[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]".toGrid()).print()
    s.minTrioDegree(7, "[[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]".toGrid()).print()
    s.minTrioDegree(4, "[[1,2],[4,1],[4,2]]".toGrid()).print()
}

class Solution5679 {
    fun minTrioDegree(n: Int, edges: Array<IntArray>): Int {
        val map = HashMap<Int, Int>()
        val matrix = Array<BooleanArray>(n + 1) { BooleanArray(n + 1) { false } }
        for (i in 1..n) map[i] = 0
        edges.forEach {
            map[it[0]] = map[it[0]]!! + 1
            map[it[1]] = map[it[1]]!! + 1
            matrix[it[0]][it[1]] = true
            matrix[it[1]][it[0]] = true
        }
        var ans = Int.MAX_VALUE
        for (i in 1..n - 2) {
            for (j in i + 1..n - 1) {
                if (matrix[i][j]) {
                    for (k in j + 1..n) {
                        if (matrix[i][k] && matrix[j][k])
                            ans = minOf(ans, map[i]!! + map[j]!! + map[k]!! - 6)
                    }
                }
            }
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}