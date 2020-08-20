package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print

class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        var a = head
        var b = head?.next
        var c = head?.next?.next
        while (b != null) {
            b.next = a
            a = b
            b = c
            c = b?.next
        }

        head?.next = null
        return a
    }
}
