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
//    node4.next = node5
    reorderList(node1)
}

fun reorderList(head: ListNode?) {
    var start: ListNode? = head ?: return

    if (start!!.next == null) {
        return
    }

    while (start?.next != null) {
        start.next = getBottom(start)
        start = start.next?.next
    }

    head.print()
}

fun getBottom(head: ListNode?): ListNode? {
    var result: ListNode? = head ?: return null

    while (result!!.next != null) {
        val tmp = result
        result = result.next
        if (result!!.next == null) {
            tmp.next = null
        }
    }

    result.next = head.next
    return result
}