package leetcode

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    reverseList(node1).print()
}

fun reverseList(head: ListNode?): ListNode? {
    var a = head
    var b = head?.next
    var c = head?.next?.next
    while (b != null) {
        b.next = a
        a = b
        b = c
        c = b?.next
    }

    head?.next = null
    return a
}