package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
//    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
    swapPairs(node1).print()
}

fun swapPairs(head: ListNode?): ListNode? {

    if (head?.next == null) {
        return head
    }
    var node = head

    val result = head.next
    while (node?.next != null) {
        val temp = node.next!!.next
        node.next!!.next = node
        node.next = if (temp?.next == null) {
            temp
        } else {
            temp.next
        }

        node = temp
    }

    return result
}