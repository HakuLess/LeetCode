package leetcode.normal

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val a = Solution547()
    a.findCircleNum(arrayOf(
            intArrayOf(1, 0, 0, 1),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 0, 1, 1)
    )).print()
}

class Solution547 {
    fun findCircleNum(M: Array<IntArray>): Int {
        var ans = 0
        val size = M.size
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (M[i][j] == 1) {
                    ans++
                    arrived(M, i, j)
                }
            }
        }
        return ans
    }

    private fun arrived(M: Array<IntArray>, i: Int, j: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(i, j))
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (c in 0 until size) {
                val item = queue.poll()
                if (item.first < 0 || item.second < 0 || item.first >= M.size
                        || item.second >= M.size || M[item.first][item.second] != 1) {
                    continue
                }
                M[item.first][item.second] = -1

                for (t in 0 until M.size) {
                    if (M[item.first][t] == 1) {
                        queue.add(Pair(item.first, t))
                    }
                    if (M[t][item.second] == 1) {
                        queue.add(Pair(t, item.second))
                    }
                }
            }
        }
    }
}