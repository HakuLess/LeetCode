package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print

class Solution143 {
    fun reorderList(head: ListNode?): Unit {
        var start: ListNode? = head ?: return
        if (start!!.next == null) {
            return
        }
        while (start?.next != null) {
            start.next = getBottom(start)
            start = start.next?.next
        }
    }

    private fun getBottom(head: ListNode?): ListNode? {
        var result: ListNode? = head ?: return null
        while (result!!.next != null) {
            val tmp = result
            result = result.next
            if (result!!.next == null) {
                tmp.next = null
            }
        }
        result.next = head.next
        return result
    }
}