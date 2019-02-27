package leetcode

import java.util.*


class KthLargest(k: Int, nums: IntArray) {
    val pq = PriorityQueue<Int>()
    val top = k

    init {
        nums.forEach {
            add(it)
        }
    }

    fun add(num: Int): Int {
        if (pq.size < top) {
            pq.offer(num)
        } else {
            if (num > pq.peek()) {
                pq.poll()
                pq.offer(num)
            }
        }
        return pq.peek()
    }
}