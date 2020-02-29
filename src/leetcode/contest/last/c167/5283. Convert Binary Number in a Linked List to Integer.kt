package leetcode.contest.last.c167

import leetcode.contest.utils.ListNode

class Solution5283 {
    fun getDecimalValue(head: ListNode?): Int {
        var cur = head
        var ans = 0
        while (cur != null) {
            ans *= 2
            ans += cur.`val`
            cur = cur.next
        }
        return ans
    }
}