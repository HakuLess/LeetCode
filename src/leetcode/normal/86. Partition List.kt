package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()
        var cur = head
        while (cur != null) {
            if (cur.`val` < x) {
                left.add(cur.`val`)
            } else {
                right.add(cur.`val`)
            }
            cur = cur.next
        }

        if (left.size == 0 || right.size == 0) {
            return head
        }

        var preNode = ListNode(0)
        var ans: ListNode? = null
        left.forEachIndexed { index, it ->
            val node = ListNode(it)
            preNode.next = node
            preNode = node

            if (index == 0) {
                ans = node
            }
        }

        right.forEach {
            val node = ListNode(it)
            preNode.next = node
            preNode = node
        }

        return ans
    }
}