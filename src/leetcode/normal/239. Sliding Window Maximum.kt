package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution239()
    s.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).print()
}

class Solution239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n: Int = nums.size
        val deque: Deque<Int> = LinkedList()
        for (i in 0 until k) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast()
            }
            deque.offerLast(i)
        }

        val ans = arrayListOf<Int>()
        ans.add(nums[deque.peekFirst()])
        for (i in k until n) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast()
            }
            deque.offerLast(i)
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst()
            }
            ans.add(nums[deque.peekFirst()])
        }
        return ans.toIntArray()
    }
}