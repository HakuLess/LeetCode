package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) {
            return null
        }
        var head1 = headA
        var head2 = headB
        while (head1 != head2) {
            head1 = if (head1 != null) {
                head1.next
            } else {
                headB
            }
            head2 = if (head2 != null) {
                head2.next
            } else {
                headA
            }
        }
        return head1
    }
}