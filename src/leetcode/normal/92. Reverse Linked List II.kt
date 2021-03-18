package leetcode.normal

import leetcode.contest.utils.*

class Solution92 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null) return null
        val arr = ArrayList(head.toIntArray().toList())
        arr.subList(left, right).reverse()
        return arr.toIntArray().toListNode()
    }

//    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
//        if (left == right) {
//            return head
//        }
//        val node0 = ListNode(0)
//        node0.next = head
//        reverseBetweenCore(node0, left + 1, right + 1)
//        return node0.next
//    }
//
//    fun reverseBetweenCore(head: ListNode?, m: Int, n: Int): ListNode? {
//
//        if (m == n) {
//            return head
//        }
//        var i = 0
//
//        var reverseHead: ListNode? = head
//        var a = reverseHead
//        while (i != m - 1) {
//            a = reverseHead
//            i++
//            reverseHead = reverseHead!!.next
//        }
//
//        var reverseEnd = reverseHead
//        while (i != n - 1) {
//            i++
//            reverseEnd = reverseEnd!!.next
//        }
//        val c = reverseEnd!!.next
//        reverseEnd.next = null
//
//        var b = reverseList(reverseHead)
//        a!!.next = b
//
//        while (b!!.next != null) {
//            b = b.next
//        }
//        b.next = c
//
//        return head
//    }
//
//    fun reverseList(head: ListNode?): ListNode? {
//        var a = head
//        var b = head?.next
//        var c = head?.next?.next
//        while (b != null) {
//            b.next = a
//            a = b
//            b = c
//            c = b?.next
//        }
//
//        head?.next = null
//        return a
//    }
}