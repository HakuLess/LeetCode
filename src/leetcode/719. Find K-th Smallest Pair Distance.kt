package leetcode


fun main(args: Array<String>) {
    smallestDistancePair(intArrayOf(1, 6, 1, 2, 3, 4, 5, 6), 4).print()
}

fun smallestDistancePair(nums: IntArray, k: Int): Int {
    nums.sort()

    var lo = 0
    var hi = nums[nums.size - 1] - nums[0]
    while (lo < hi) {
        val mi = (lo + hi) / 2
        var count = 0
        var left = 0
        for (right in nums.indices) {
            while (nums[right] - nums[left] > mi) {
                left++
            }
            count += right - left
        }
        // count = number of pairs with distance <= mi
        if (count >= k)
            hi = mi
        else
            lo = mi + 1
    }
    return lo
}