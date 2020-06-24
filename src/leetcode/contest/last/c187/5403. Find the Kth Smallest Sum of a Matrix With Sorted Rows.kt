package leetcode.contest.last.c187

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5403()
//    s.kthSmallest(arrayOf(
//            intArrayOf(1, 3, 11),
//            intArrayOf(2, 4, 6)
//    ), 5).print()

    s.kthSmallest(arrayOf(
            intArrayOf(1, 10, 10),
            intArrayOf(1, 4, 5),
            intArrayOf(2, 3, 6)
    ), 5).print()
}

class Solution5403 {
    fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
        val len = mat.size
        var sum = 0
        for (i in 0 until len) {
            sum += mat[i][0]
        }
        var queue = PriorityQueue<Int>(compareByDescending { it })
        queue.add(0)
        for (m in mat) {
            val next = PriorityQueue<Int>(compareByDescending { it })
            for (i in queue) {
                next.add(i)
            }
            for (i in 1 until m.size) {
                for (j in queue) {
                    val item = j + m[i] - m[0]
                    next.add(item)
                    if (next.size > k) {
                        next.poll()
                    }
                }
            }
            queue = next
        }
        return sum + queue.poll()
    }
}