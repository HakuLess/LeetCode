package leetcode.normal

import leetcode.ListNode
import leetcode.print

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
    reverseBetween(node1, 1, 5).print()

//    val node1 = ListNode(1)
//    val node2 = ListNode(2)
//
//    node1.next = node2
//    reverseBetween(node1, 1, 2).print()
}

fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {

    if (m == n) {
        return head
    }
    val node0 = ListNode(0)
    node0.next = head
    reverseBetweenCore(node0, m + 1, n + 1)

    return node0.next
}

fun reverseBetweenCore(head: ListNode?, m: Int, n: Int): ListNode? {

    if (m == n) {
        return head
    }
    var i = 0

    var reverseHead: ListNode? = head
    var a = reverseHead
    while (i != m - 1) {
        a = reverseHead
        i++
        reverseHead = reverseHead!!.next
    }

    var reverseEnd = reverseHead
    while (i != n - 1) {
        i++
        reverseEnd = reverseEnd!!.next
    }
    val c = reverseEnd!!.next
    reverseEnd.next = null

    var b = reverseList(reverseHead)
    a!!.next = b

    while (b!!.next != null) {
        b = b.next
    }
    b.next = c

    return head
}

//fun reverseList(head: ListNode?): ListNode? {
//    var a = head
//    var b = head?.next
//    var c = head?.next?.next
//    while (b != null) {
//        b.next = a
//        a = b
//        b = c
//        c = b?.next
//    }
//
//    head?.next = null
//    return a
//}