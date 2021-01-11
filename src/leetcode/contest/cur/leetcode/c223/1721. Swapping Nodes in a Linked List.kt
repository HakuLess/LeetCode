package leetcode.contest.cur.leetcode.c223

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.toIntArray
import leetcode.contest.utils.toListNode

class Solution1721 {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val arr = head.toIntArray()
        val n = arr.size
        val temp = arr[k - 1]
        arr[k - 1] = arr[n - k + 1]
        arr[n - k + 1] = temp
        return arr.toListNode()
    }
}