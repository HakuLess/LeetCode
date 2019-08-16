package leetcode.contest.utils

//  Definition for singly-linked list.
class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

inline fun IntArray.toListNode(): ListNode {
    var node = ListNode(this[0])
    val head = node
    for (i in 1 until this.size) {
        val cur = ListNode(this[i])
        node.next = cur
        node = cur
    }
    return head
}

inline fun ListNode?.print() {
    var node = this
    while (node != null) {
        print("${node.`val`}, ")
        node = node.next
    }
    println()
}

inline fun ListNode?.count(): Int {
    var c = 0
    var p: ListNode? = this ?: return 0
    while (p != null) {
        p = p.next
        c++
    }
    return c
}