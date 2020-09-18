package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution237 {
    fun deleteNode(node: ListNode?) {
        if (node == null) return
        node.`val` = node.next!!.`val`
        node.next = node.next!!.next
    }
}