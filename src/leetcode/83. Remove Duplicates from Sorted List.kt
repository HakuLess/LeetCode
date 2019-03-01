package leetcode

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }

    var cur = head.next
    var pre = head
    while (cur != null) {
        if (cur.`val` != pre!!.`val`) {
            pre.next = cur
            pre = pre.next
        } else {
            pre.next = null
        }
        cur = cur.next
    }

    return head
}