package leetcode.normal

import leetcode.ListNode

class Solution82 {

    fun deleteDuplicates(head: ListNode): ListNode? {
        val dummy = ListNode(0)
        var cur: ListNode? = head
        var prev = dummy
        dummy.next = head

        while (cur?.next != null) {
            if (cur.next!!.`val` == cur.`val`) {
                while (cur!!.next != null && cur.next!!.`val` == cur.`val`) {
                    cur = cur.next
                }
                prev.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }

        return dummy.next
    }
}