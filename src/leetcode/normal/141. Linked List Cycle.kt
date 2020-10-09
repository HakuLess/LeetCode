package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution141 {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        val set = HashSet<ListNode>()
        var cur = head
        while (cur != null) {
            if (cur in set) return true
            set.add(cur)
            cur = cur.next
        }
        return false
    }
}