package leetcode.learn

import leetcode.contest.utils.TreeNode

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) {
        return null
    }
    return geneBST(nums, 0, nums.size - 1)
}

fun geneBST(nums: IntArray, start: Int, end: Int): TreeNode? {
    if (end < start) {
        return null
    }
    val mid = (start + end) shr 1

    val root = TreeNode(nums[mid])
    root.left = geneBST(nums, start, mid - 1)
    root.right = geneBST(nums, mid + 1, end)
    return root
}