package leetcode

fun main(args: Array<String>) {
    val intArray = intArrayOf(4, 1, 2, 1, 2, 4, 7)
    singleNumber(intArray).print()
}

fun singleNumber(nums: IntArray): Int {
    var result = 0
    nums.forEach {
        result = result xor it
    }
    return result
}