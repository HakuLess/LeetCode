package leetcode.contest.cur.mst

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.toIntArray
import leetcode.contest.utils.toListNode

class Solution0201 {
    fun removeDuplicateNodes(head: ListNode?): ListNode? {
        if (head == null) return null
        return head.toIntArray().distinct().toIntArray().toListNode()
    }
}