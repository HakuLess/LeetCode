package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }
        var right = head
        var left = head
        for (i in 0..n) {
            if (right == null) {
                return head.next
            }
            right = right.next
        }
        while (right != null) {
            right = right.next
            left = left!!.next
        }
        left!!.next = left.next!!.next
        return head
    }
}