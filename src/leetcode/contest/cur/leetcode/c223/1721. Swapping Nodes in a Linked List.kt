package leetcode.contest.cur.leetcode.c223

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.toIntArray
import leetcode.contest.utils.toListNode

class Solution1721 {
//    fun swapNodes(head: ListNode?, k: Int): ListNode? {
//        if (head == null) {
//            return null
//        }
//        if (head.next == null) {
//            return head
//        }
//        var cur: ListNode? = head
//        var slow: ListNode? = head
//        var fast: ListNode? = head
//        var index = 1
//        while (cur?.next != null) {
//            if (index < k) {
//                slow = slow?.next
//            } else {
//                fast = fast?.next
//            }
//            cur = cur.next
//            index++
//        }
//        val slowValue = slow?.`val` ?: 0
//        slow?.`val` = fast?.`val` ?: 0
//        fast?.`val` = slowValue
//        return head
//    }

    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val arr = head.toIntArray()
        val n = arr.size
        val temp = arr[k - 1]
        arr[k - 1] = arr[n - k + 1]
        arr[n - k + 1] = temp
        return arr.toListNode()
    }
}