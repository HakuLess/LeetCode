package leetcode.contest.last.c177

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5170()
    s.validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, -1, -1, -1)).print()
}

class Solution5170 {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val seen = IntArray(n)
        for (i in 0 until n) {
            if (leftChild[i] != -1) {
                seen[leftChild[i]]++
            }
            if (rightChild[i] != -1) {
                seen[rightChild[i]]++
            }
        }
        seen.print()
        if (seen.count { it == 0 } != 1) {
            println(11)
            return false
        }
        if (seen.count { it == 1 } != n - 1) {
            return false
        }
        return true
    }
}