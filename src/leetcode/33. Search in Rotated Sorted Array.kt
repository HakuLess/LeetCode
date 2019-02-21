package leetcode

fun search(nums: IntArray, target: Int): Int {
    var offset = nums.lastIndex
    for (i in 0 until nums.size - 1) {
        if (nums[i] > nums[i + 1]) {
            offset = i
        }
    }
    nums.sort()

    var left = 0
    var right = nums.lastIndex
    var middle = (left + right) shr 1

    while (left <= right) {
        println("$left $right $middle")
        middle = (left + right) shr 1
        when {
            nums[middle] > target -> {
                right = middle - 1
            }
            nums[middle] < target -> {
                left = middle + 1
            }
            else -> return (middle + offset) % nums.size
        }
    }

    return -1
}