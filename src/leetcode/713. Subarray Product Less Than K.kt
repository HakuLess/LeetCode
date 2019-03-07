package leetcode

fun main(args: Array<String>) {
    val s = Solution713()
//    s.numSubarrayProductLessThanK(intArrayOf(10, 5, 2, 6), 100).print()
    s.numSubarrayProductLessThanK(intArrayOf(1, 2, 3), 0).print()
}

class Solution713 {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var start = 0
        var end = 0
        var product = 1
        var ans = 0

        while (end < nums.size) {
            product *= nums[end]
            println("$product, $start, $end")

            if (product >= k) {
                product /= nums[start]
                product /= nums[end]
                start++
                if (start > end) {
                    end = start
                    product = 1
                }
            } else {
                ans += end - start + 1
                end++
            }
        }
        return ans
    }
}