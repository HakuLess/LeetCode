package leetcode.contest.last.c187

import java.util.*


class Solution5402 {
//    fun longestSubarray(nums: IntArray, limit: Int): Int {
//        nums.forEach {
//
//        }
//    }

    fun longestSubarray(numbers: IntArray, maxGap: Int): Int {
        var best = 0
        var bestStart = 0
        var bestEnd = 0
        val minQueue: Deque<Int> = LinkedList()
        val maxQueue: Deque<Int> = LinkedList()
        var start = 0
        var end = 0
        while (end < numbers.size) {
            val x = numbers[end]
            // add end to the minQueue keeping increasing order
            while (!minQueue.isEmpty() && numbers[minQueue.peekLast()] >= x) {
                minQueue.removeLast()
            }
            minQueue.addLast(end)
            // add end to the maxQueue keeping decreasing order
            while (!maxQueue.isEmpty() && numbers[maxQueue.peekLast()] <= x) {
                maxQueue.removeLast()
            }
            maxQueue.addLast(end)
            // minimum is at the front of minQueue
            val minIdx = minQueue.peekFirst()
            val minVal = numbers[minIdx]
            // maximum is at the front of maxQueue
            val maxIdx = maxQueue.peekFirst()
            val maxVal = numbers[maxIdx]
            // check
            if (maxVal - minVal > maxGap) {
                start++
                if (start > minQueue.peekFirst()) {
                    minQueue.removeFirst()
                }
                if (start > maxQueue.peekFirst()) {
                    maxQueue.removeFirst()
                }
            } else { // track progress
                if (end - start + 1 > best) {
                    best = end - start + 1
                    bestStart = start
                    bestEnd = end
                }
                end++
            }
        }
        return best
    }
}