package leetcode

fun main(args: Array<String>) {
    val intArray = intArrayOf(3, 3, 4, 4, 5, 5, 6, 7, 7, 7)
    removeDuplicates(intArray).print()
    intArray.print()
}

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    var cur: Int? = null
    nums.forEach {
        if (cur == null || cur != it) {
            nums[i] = it
            i++
            cur = it
        }
    }

    return i
}