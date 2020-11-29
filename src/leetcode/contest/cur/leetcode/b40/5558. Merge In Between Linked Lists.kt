package leetcode.contest.cur.leetcode.b40

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
class Solution5558 {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var c0 = a
        var c1 = b
        var cur = list1
        while (c0 != 1) {
            cur = cur?.next
            c0--
            c1--
        }
        var h = cur
        while (c1 != 1) {
            cur = cur?.next
            c1--
        }
        h?.next = list2
        while (h?.next != null) {
            h = h.next
        }
        h?.next = cur
        return list1
    }
}