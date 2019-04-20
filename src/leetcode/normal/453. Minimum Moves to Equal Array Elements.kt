package leetcode.normal

fun minMoves(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    var result = 0
    val min = nums.min()
    nums.forEach {
        result += it - min!!
    }
    return result
}