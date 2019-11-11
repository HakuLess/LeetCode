package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print
import java.util.*

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
    val s = Solution25()
//    s.reverseKGroup(node1, 2).print()
    s.reverseKGroup(node1, 1).print()
}

class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }
        if (k == 1) {
            return head
        }
        val st = Stack<Pair<ListNode?, ListNode?>>()
        var pre = head
        var next = head.next
        for (i in 0 until k - 1) {
            st.add(Pair(pre, next))
            pre = pre?.next
            next = next?.next
        }

        val ans = st.peek().second
        while (st.isNotEmpty()) {
            val item = st.pop()
            if (item.second == null) {
                return head
            }
            item.second?.next = item.first
        }
        head.next = reverseKGroup(next, k)
        return ans
    }
}