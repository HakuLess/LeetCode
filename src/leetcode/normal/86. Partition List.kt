package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print
import leetcode.contest.utils.toListNode

fun main(args: Array<String>) {
    val s = Solution86()
    s.partition(intArrayOf(1, 4, 3, 2, 5, 2).toListNode(), 3).print()
}

class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var left = ListNode(0)
        val ansPre = left
        var right = ListNode(0)
        val ansSuf = right
        var cur = head
        while (cur != null) {
            if (cur.`val` < x) {
                left.next = cur
                left = cur
            } else {
                right.next = cur
                right = cur
            }
            cur = cur.next
        }
        right.next = null
        left.next = ansSuf.next
        return ansPre.next
    }

//    fun partition(head: ListNode?, x: Int): ListNode? {
//        val left = arrayListOf<Int>()
//        val right = arrayListOf<Int>()
//        var cur = head
//        while (cur != null) {
//            if (cur.`val` < x) {
//                left.add(cur.`val`)
//            } else {
//                right.add(cur.`val`)
//            }
//            cur = cur.next
//        }
//
//        if (left.size == 0 || right.size == 0) {
//            return head
//        }
//
//        var preNode = ListNode(0)
//        var ans: ListNode? = null
//        left.forEachIndexed { index, it ->
//            val node = ListNode(it)
//            preNode.next = node
//            preNode = node
//
//            if (index == 0) {
//                ans = node
//            }
//        }
//
//        right.forEach {
//            val node = ListNode(it)
//            preNode.next = node
//            preNode = node
//        }
//
//        return ans
//    }
}