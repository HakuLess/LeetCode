package leetcode.normal

fun main(args: Array<String>) {
//    val source = arrayListOf(1, 2, 3, 4).toIntArray()
    val source = arrayListOf(1, 2, 3, 3, 3).toIntArray()
//    val source = arrayListOf(4, 3, 2, 1).toIntArray()
    println(findUnsortedSubarray(source))
}

fun findUnsortedSubarray(nums: IntArray): Int {
    val leftStack = arrayListOf<Int>()
    val rightStack = arrayListOf<Int>()
    var stop = false
    for (i in 0 until nums.size) {
        if (!stop) {
            if (i == nums.size - 1) {
                return 0
            }
            if (nums[i] <= nums[i + 1]) {
                leftStack.add(nums[i])
            } else {
                stop = true
            }
        } else {
            while (leftStack.size != 0 && leftStack[leftStack.size - 1] > nums[i]) {
                leftStack.removeAt(leftStack.size - 1)
            }
        }
    }

    stop = false
    for (i in nums.size - 1 downTo 0) {
        if (!stop) {
            if (nums[i - 1] <= nums[i]) {
                rightStack.add(nums[i])
            } else {
                stop = true
            }
        } else {
            while (rightStack.size != 0 && rightStack[rightStack.size - 1] < nums[i]) {
                rightStack.removeAt(rightStack.size - 1)
            }
        }
    }

    return nums.size - leftStack.size - rightStack.size
}