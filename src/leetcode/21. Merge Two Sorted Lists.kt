package leetcode

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }

    var root = ListNode(0)
    val head = root
    var ll1 = l1
    var ll2 = l2
    while (ll1 != null && ll2 != null) {
        if (ll1.`val` < ll2.`val`) {
            root.next = ll1
            ll1 = ll1.next
        } else {
            root.next = ll2
            ll2 = ll2.next
        }
        root = root.next!!
    }

    if (ll1 != null) {
        root.next = ll1
    }
    if (ll2 != null) {
        root.next = ll2
    }
    return head.next
}