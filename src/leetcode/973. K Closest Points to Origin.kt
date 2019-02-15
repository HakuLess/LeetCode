package leetcode

import java.util.*

fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
    val queue = PriorityQueue<IntArray>(K + 1, compareBy {
        -(it[0] * it[0] + it[1] * it[1])
    })

    points.forEach {
        queue.add(it)
        if (queue.size > K) {
            queue.poll()
        }
    }

    return queue.toTypedArray()
}