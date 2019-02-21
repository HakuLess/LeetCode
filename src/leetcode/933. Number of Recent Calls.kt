package leetcode

import java.util.*

class RecentCounter() {

    val queue: Queue<Int> = LinkedList()

    fun ping(t: Int): Int {
        while (queue.isNotEmpty() && queue.peek() < t - 3000) {
            queue.poll()
        }
        queue.offer(t)
        return queue.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */