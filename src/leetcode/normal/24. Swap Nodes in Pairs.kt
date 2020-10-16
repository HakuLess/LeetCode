package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    val s = Solution24()
    s.swapPairs(node1).print()
}

class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val temp = head.next
        head.next = swapPairs(head.next?.next)
        temp?.next = head
        return temp
    }
}