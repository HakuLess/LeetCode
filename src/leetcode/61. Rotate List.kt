package leetcode

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
    rotateRight(node1, 2).print()
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 0) {
        return head
    }
    var total = 1
    var a = head
    while (a!!.next != null) {
        total++
        a = a.next
    }
    a.next = head

    var b = a
    var i = total - k % total + 1
    i.print()
    while (i != 0) {
        i--
        b = a
        a = a!!.next
    }
    b!!.next = null
    return a
}