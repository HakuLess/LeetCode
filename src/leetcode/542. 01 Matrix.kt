package leetcode

import java.util.*
import kotlin.collections.HashSet

fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return arrayOf()
    }

    val hashset = hashSetOf<Pair<Int, Int>>()
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            if (matrix[i][j] == 0) {
                queue.offer(Pair(i, j))
            }
        }
    }

    var step = -1
    while (queue.isNotEmpty()) {
        val size = queue.size
        step++
        for (i in 0 until size) {
            val item = queue.poll()
            fillMatrix(item.first, item.second, step, queue, hashset, matrix)
        }
    }
    return matrix
}

fun fillMatrix(x: Int, y: Int, target: Int, queue: Queue<Pair<Int, Int>>, hashSet: HashSet<Pair<Int, Int>>, matrix: Array<IntArray>) {
    if (x >= 0 && x < matrix.size && y >= 0 && y < matrix[0].size && Pair(x, y) !in hashSet) {
        matrix[x][y] = target
        hashSet.add(Pair(x, y))

        queue.offer(Pair(x + 1, y))
        queue.offer(Pair(x - 1, y))
        queue.offer(Pair(x, y + 1))
        queue.offer(Pair(x, y - 1))
    }
}