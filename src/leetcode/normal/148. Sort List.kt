package leetcode.normal

import leetcode.ListNode


/**
 * Created by HaKu on 2018/9/18.
 *
 * Don't Finish
 */
fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node4
    node4.next = node3
    node3.next = node2

    var sortedList = sortList(node1)
    while (sortedList?.next != null) {
        println(sortedList.`val`)
        sortedList = sortedList.next
    }
}

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val tmpHead = ListNode()
    tmpHead.next = head
    quickSort(tmpHead, head, null)
    return tmpHead.next
}

private fun quickSort(headPre: ListNode, head: ListNode?, tail: ListNode?) {
    if (head != tail && head!!.next != tail) {
        val mid = partition(headPre, head, tail)
        quickSort(headPre, head, mid)
        quickSort(mid, mid.next, tail)
    }
}

private fun partition(lowPre: ListNode, low: ListNode, high: ListNode?): ListNode {
    val key = low.`val`
    // less than key
    var lt: ListNode? = ListNode()
    // more than key
    var mt: ListNode? = ListNode()

    val left = ListNode()
    left.next = lt

    val right = ListNode()
    right.next = mt

    var cur: ListNode? = low.next

    while (cur != high) {
        if (cur!!.`val` < key) {
            lt?.next = cur
            lt = lt?.next
        } else if (cur.`val` > key) {
            mt?.next = cur
            mt = mt?.next
        }
        cur = cur.next
    }

    mt?.next = high
    lt?.next = low
    lowPre.next = left.next
    low.next = right.next

    return low
}

