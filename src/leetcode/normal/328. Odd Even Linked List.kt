package leetcode.normal

import leetcode.contest.utils.ListNode


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }
        val evenHead = head.next
        var odd = head
        var even = evenHead
        while (even?.next != null) {
            odd!!.next = even.next
            odd = odd.next
            even.next = odd!!.next
            even = even.next
        }
        odd!!.next = evenHead
        return head
    }
}