package leetcode

import java.util.*

fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return true
    }
    val bottom = matrix.size - 1
    val right = matrix[0].size - 1
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    val hashSet = hashSetOf<Pair<Int, Int>>()
    queue.offer(Pair(bottom, 0))
    while (queue.isNotEmpty()) {
        val size = queue.size
        var ans = 0
        var isSetAns = false
        for (i in 0 until size) {
            val item = queue.poll()
            println("${item.first} ${item.second}")
            if (item.first in 0..bottom && item.second in 0..right) {
                if (Pair(item.first - 1, item.second) !in hashSet) {
                    queue.add(Pair(item.first - 1, item.second))
                    hashSet.add(Pair(item.first - 1, item.second))
                }
                if (Pair(item.first, item.second + 1) !in hashSet) {
                    queue.add(Pair(item.first, item.second + 1))
                    hashSet.add(Pair(item.first, item.second + 1))
                }
                if (!isSetAns) {
                    ans = matrix[item.first][item.second]
                    isSetAns = true
                } else if (ans != matrix[item.first][item.second]) {
                    println("$ans ${item.first} ${item.second} ${matrix[item.first][item.second]}")
                    return false
                }
            }
        }
    }
    return true
}