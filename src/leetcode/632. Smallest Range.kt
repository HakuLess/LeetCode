package leetcode

import java.util.PriorityQueue


class Solution632 {

    fun smallestRange(nums: List<List<Int>>): IntArray {
        val indexes = IntArray(nums.size) { 0 }
        var ans = Integer.MAX_VALUE
        var result = IntArray(2)

        val pq = PriorityQueue<Int>(compareBy {
            nums[it][indexes[it]]
        })

        var max = Integer.MIN_VALUE
        for (i in 0 until nums.size) {
            pq.offer(i)
            max = maxOf(max, nums[i][indexes[i]])
        }

        while (true) {
            val minIndex = pq.poll()
            val min = nums[minIndex][indexes[minIndex]]
            if (ans > max - min) {
                ans = max - min
                result = intArrayOf(min, max)
            }

            println("$min $max")
            indexes[minIndex]++
            if (indexes[minIndex] >= nums[minIndex].size) {
                return result
            }
            pq.offer(minIndex)
            max = maxOf(max, nums[minIndex][indexes[minIndex]])
        }
    }
}