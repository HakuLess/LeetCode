package leetcode.normal

import java.util.*

class Solution542 {
    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return arrayOf()
        }
        val hashSet = hashSetOf<Pair<Int, Int>>()
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    queue.offer(Pair(i, j))
                }
            }
        }

        fun bfs(x: Int, y: Int, target: Int) {
            if (x >= 0 && x < matrix.size && y >= 0 && y < matrix[0].size && Pair(x, y) !in hashSet) {
                matrix[x][y] = target
                hashSet.add(Pair(x, y))
                queue.offer(Pair(x + 1, y))
                queue.offer(Pair(x - 1, y))
                queue.offer(Pair(x, y + 1))
                queue.offer(Pair(x, y - 1))
            }
        }

        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                bfs(item.first, item.second, step)
            }
        }
        return matrix
    }
}