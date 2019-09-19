package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print
import leetcode.contest.utils.toListNode

fun main(args: Array<String>) {
    val s = Solution725()
    s.splitListToParts(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toListNode(), 3).forEach {
        it.print()
    }

    s.splitListToParts(intArrayOf(1, 2, 3, 4).toListNode(), 5).forEach {
        it.print()
    }
//    s.splitListToParts(intArrayOf(1, 2, 3).toListNode(), 3)
}

class Solution725 {
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        if (root == null) {
            return Array(k) { null }
        }
//        val total = root.count()
        var total = 0
        var p = root
        while (p != null) {
            p = p.next
            total++
        }

        val sep = arrayListOf<Int>()
        for (i in 0 until k) {
            sep.add(total / k + if (i < total % k) 1 else 0)
        }
        var node = root
        var pre: ListNode?
        var step = 0
        var c = 0

        val ans = Array<ListNode?>(k) { null }
        ans[c] = node
        while (node != null) {
            step++
            if (step == sep[c]) {
                c++
                step = 0
                if (c < k) {
                    ans[c] = node.next
                }
                pre = node
                node = node.next
                pre.next = null
            } else {
                node = node.next
            }
        }

        return ans
    }
}