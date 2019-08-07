package leetcode.normal

import leetcode.contest.utils.ListNode
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution1030()
//    s.nextLargerNodes(intArrayOf(2, 1, 5)).print()
//    s.nextLargerNodes(intArrayOf(2, 7, 4, 3, 5)).print()
//    s.nextLargerNodes(intArrayOf(1, 7, 5, 1, 9, 2, 5, 1)).print()
}

class Solution1030 {
//    fun nextLargerNodes(a: IntArray): IntArray {
    fun nextLargerNodes(head: ListNode?): IntArray {
        val list = arrayListOf<Int>()
        var cur = head
        while (cur != null) {
            list.add(-cur.`val`)
            cur = cur.next
        }
//        a.forEach {
////            list.add(-it)
////        }

        for (i in 0 until list.size) {
            for (j in i + 1 until list.size) {
                if (abs(list[j]) > abs(list[i])) {
                    list[i] = abs(list[j])
                    break
                }
            }
        }

        return list.map {
            if (it < 0) {
                0
            } else {
                it
            }
        }.toIntArray()
    }
}