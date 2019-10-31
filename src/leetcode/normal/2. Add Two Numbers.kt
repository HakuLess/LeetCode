package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.count
import leetcode.contest.utils.print
import leetcode.contest.utils.toListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
fun main(args: Array<String>) {
    val s = Solution2()
    s.addTwoNumbers(
            intArrayOf(2, 4, 3).toListNode(),
            intArrayOf(5, 6, 4).toListNode()
    ).print()
}

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val ans = ListNode(0)
        var head = ans
        var a = l1
        var b = l2
        var add = 0
        while (a != null || b != null || add != 0) {
            val sum = add + (a?.`val` ?: 0) + (b?.`val` ?: 0)
            head.next = ListNode(sum % 10)
            add = sum / 10

            a = a?.next
            b = b?.next
            head = head.next!!
        }
        return ans.next
    }
}