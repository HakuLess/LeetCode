package leetcode.contest.last.c151

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.print
import leetcode.contest.utils.toListNode

fun main(args: Array<String>) {
    val s = Solution1171()
//    s.removeZeroSumSublists(intArrayOf(1, 2, -3, 3, 1).toListNode()).print()
//    s.removeZeroSumSublists(intArrayOf(1, 2, 3, -3, 4).toListNode()).print()
//    s.removeZeroSumSublists(intArrayOf(1, 2, 3, -3, -2).toListNode()).print()
    s.removeZeroSumSublists(intArrayOf(1, -1).toListNode()).print()
}

class Solution1171 {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        var p: ListNode? = head ?: return null
        val l = arrayListOf<Int>()
        while (p != null) {
            if (p.`val` != 0) {
                l.add(p.`val`)
            }
            p = p.next
        }
        delete(l)
        if (l.isEmpty()) {
            return null
        }
        return l.toIntArray().toListNode()
    }

    private fun delete(l: ArrayList<Int>) {
//        for (i in 0 until l.size) {
//            print("${l[i]}, ")
//        }
//        println()
        for (i in 0 until l.size) {
            var ans = l[i]
            for (j in i + 1 until l.size) {
                ans += l[j]
                if (ans == 0) {
//                    println("$i, $j")
                    for (k in j downTo i) {
                        l.removeAt(k)
                    }
                    delete(l)
                    return
                }
            }
        }
    }
}