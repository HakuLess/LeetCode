package leetcode.normal

import java.util.*

class Solution503 {
    fun nextGreaterElements(nums: IntArray): IntArray? {
        val n = nums.size
        val ans = IntArray(n) { -1 }
        val stack = Stack<Int>()
        for (i in 0 until n * 2 - 1) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ans[stack.pop()] = nums[i % n]
            }
            stack.push(i % n)
        }
        return ans
    }

//    fun nextGreaterElements(nums: IntArray): IntArray {
//        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
//        val n = nums.size
//        val ans = IntArray(n) { -1 }
//        for (i in 0 until 2 * n) {
//            if (i in nums.indices) {
//                pq.offer(Pair(nums[i], i))
//            }
//            while (nums[i % n] > pq.peek().first) {
//                ans[pq.poll().second] = nums[i % n]
//            }
//        }
//        return ans
//    }
}