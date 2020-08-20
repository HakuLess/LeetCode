package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.toIntArray

class Solution109 {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) return null
        val arr = head.toIntArray()
        fun buildNode(left: Int, right: Int): TreeNode? {
            if (right < left) return null
            val mid = (left + right) / 2
            val root = TreeNode(arr[mid])
            root.left = buildNode(left, mid - 1)
            root.right = buildNode(mid + 1, right)
            return root
        }
        return buildNode(0, arr.lastIndex)
    }
}