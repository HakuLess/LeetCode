package leetcode

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) {
        return null
    }

    val root = ListNode(0)
    var pre = root
    var cur = head
    while (cur != null) {
        if (cur.`val` != `val`) {
            pre.next = cur
            pre = pre.next!!
        } else {
            pre.next = null
        }
        cur = cur.next
    }
    return root.next
}