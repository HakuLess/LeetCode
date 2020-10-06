package leetcode.contest.last.c177

import leetcode.contest.utils.UFS
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5170()
//    s.validateBinaryTreeNodes(4, intArrayOf(1, -1, 3, -1), intArrayOf(2, -1, -1, -1)).print()
    s.validateBinaryTreeNodes(4, intArrayOf(3, -1, 1, -1), intArrayOf(-1, -1, 0, -1)).print()
}

class Solution5170 {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val ufs = UFS(n)
        for (i in leftChild.indices) {
            if (leftChild[i] != -1) {
                if (ufs.find(i) == ufs.find(leftChild[i])) {
                    return false
                }
                ufs.union(i, leftChild[i])
            }
            if (rightChild[i] != -1) {
                if (ufs.find(i) == ufs.find(rightChild[i])) {
                    return false
                }
                ufs.union(i, rightChild[i])
            }
        }
        return ufs.size == 1
    }
}