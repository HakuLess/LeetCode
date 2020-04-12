package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution876 {
    fun middleNode(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        return slow
    }
}