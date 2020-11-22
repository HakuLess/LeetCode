package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution147() {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }
        val dummyHead = ListNode(0)
        dummyHead.next = head
        var lastSorted = head
        var curr = head.next
        while (curr != null) {
            if (lastSorted!!.`val` <= curr.`val`) {
                lastSorted = lastSorted.next
            } else {
                var prev: ListNode? = dummyHead
                while (prev!!.next!!.`val` <= curr.`val`) {
                    prev = prev.next
                }
                lastSorted.next = curr.next
                curr.next = prev.next
                prev.next = curr
            }
            curr = lastSorted!!.next
        }
        return dummyHead.next
    }
}