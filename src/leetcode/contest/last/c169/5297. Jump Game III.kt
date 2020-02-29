package leetcode.contest.last.c169

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5297()
    s.canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5).print()
}

class Solution5297 {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val seen = HashSet<Int>()
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(start)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item in arr.indices && item !in seen) {
                    seen.add(item)
                    if (arr[item] == 0) {
                        return true
                    } else {
                        queue.offer(item + arr[item])
                        queue.offer(item - arr[item])
                    }
                }
            }
        }
        return false
    }
}