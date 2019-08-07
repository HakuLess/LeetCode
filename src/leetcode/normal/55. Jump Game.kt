package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val array = intArrayOf(2, 3, 1, 1, 4)
    canJump(array).print()
}

fun canJump(nums: IntArray): Boolean {
    if (nums.isEmpty()) {
        return false
    }
    val ans = BooleanArray(nums.size) { false }
    ans[0] = true
    for (i in 0 until nums.size) {
        for (j in 1..nums[i]) {
            if (ans[i] && i + j < ans.size) {
                ans[i + j] = true
            }
        }
        ans.forEach { print("$it ,") }
        println()
    }
//    ans.forEach { print("$it ,") }
    return ans.last()
}