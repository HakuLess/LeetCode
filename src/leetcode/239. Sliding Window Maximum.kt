package leetcode

import java.util.*

fun main(args: Array<String>) {
    val s = Solution239()
    s.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).print()
}

class Solution239 {

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || k == 0) {
            return intArrayOf()
        }
        if (nums.size <= k) {
            return intArrayOf(nums.max()!!)
        }

        val pq = PriorityQueue<Int>(compareBy { -it })

        for (i in 0 until k) {
            pq.offer(nums[i])
        }
        val ans = arrayListOf<Int>()

        for (i in k until nums.size) {
            pq.forEach {
                print("$it, ")
            }
            println("remove ${nums[i - k]}")
            ans.add(pq.peek())
            pq.remove(nums[i - k])
            pq.offer(nums[i])
        }
        ans.add(pq.peek())

        return ans.toIntArray()
    }

}