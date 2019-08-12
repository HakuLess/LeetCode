package leetcode.contest.cur

fun main(args: Array<String>) {
    val s = Solution480()
    s.medianSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).forEach {
        print("$it, ")
    }
}

class Solution480 {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val pq = arrayListOf<Int>()
        for (i in 0 until k - 1) {
            pq.add(nums[i])
        }

        val ans = arrayListOf<Double>()
        for (i in k - 1..nums.lastIndex) {
            pq.add(nums[i])
            pq.sort()
            if (k % 2 == 0) {
                ans.add((pq[k / 2 - 1].toDouble() + pq[k / 2].toDouble()) / 2)
            } else {
                ans.add(pq[k / 2].toDouble())
            }
            pq.remove(nums[i - k + 1])
        }
        return ans.toDoubleArray()
    }
}