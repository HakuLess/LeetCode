package leetcode.contest.cur.leetcode.c240

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5752()
    s.maxSumMinProduct(intArrayOf(2, 3, 3, 1, 2)).print()
}

// Solution88
// 单调栈 前缀和
class Solution5752 {
    fun maxSumMinProduct(nums: IntArray): Int {
        val mod = 1000000007L
        val preSum = LongArray(nums.size + 1)
        for (i in nums.indices) {
            preSum[i + 1] = preSum[i] + nums[i]
        }
        val rightSmall = IntArray(nums.size) { nums.size }
        val leftSmall = IntArray(nums.size) { -1 }
        val stack = Stack<Int>()
        for (i in nums.indices) {
            while (stack.isNotEmpty() && nums[i] < nums[stack.peek()]) {
                rightSmall[stack.pop()] = i
            }
            stack.push(i)
        }
        stack.clear()
        for (i in nums.indices.reversed()) {
            while (stack.isNotEmpty() && nums[i] < nums[stack.peek()]) {
                leftSmall[stack.pop()] = i
            }
            stack.push(i)
        }
        var ans = 0L
        for (i in nums.indices) {
            val left = leftSmall[i]
            val right = rightSmall[i]
            ans = maxOf(ans, nums[i] * (preSum[right] - preSum[left + 1]))
        }
        return (ans % mod).toInt()
    }

//    fun maxSumMinProduct(nums: IntArray): Int {
//        val mod = 1000000007L
//        val preSum = LongArray(nums.size + 1)
//        for (i in nums.indices) {
//            preSum[i + 1] = preSum[i] + nums[i]
//        }
//        val set = TreeSet<Int>()
//        set.add(-1)
//        set.add(nums.size)
//        val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.first })
//        for (i in nums.indices) {
//            pq.add(Pair(nums[i], i))
//        }
//        var ans = 0L
//        while (!pq.isEmpty()) {
//            val item = pq.poll()
//            val start = set.lower(item.second)!!
//            val end = set.higher(item.second)!!
//            val sum = preSum[end] - preSum[start + 1]
//            ans = maxOf(sum * item.first, ans)
//            set.add(item.second)
//        }
//        return (ans % mod).toInt()
//    }
}