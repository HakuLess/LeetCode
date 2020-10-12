package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution142 {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null
        val set = HashSet<ListNode>()
        var cur = head
        while (cur != null) {
            if (cur in set) return cur
            set.add(cur)
            cur = cur.next
        }
        return null
    }
}