package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution179()
    s.largestNumber(intArrayOf(3, 30, 34, 5, 9)).print()
    s.largestNumber(intArrayOf(10, 2)).print()
    s.largestNumber(intArrayOf(12, 121)).print()
    s.largestNumber(intArrayOf(824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247)).print()
}

class Solution179 {
    fun largestNumber(nums: IntArray): String {
        return nums.map { it.toString() }
                .sortedWith(Comparator { o1, o2 ->
                    (o2 + o1).compareTo(o1 + o2)
                })
                .joinToString("")
                .takeUnless { it.startsWith("0") }
                ?: "0"
    }

//    fun largestNumber(nums: IntArray): String {
//        if (nums.all { it == 0 }) {
//            return "0"
//        }
//        val ans = nums.map { it.toString() }.sortedWith(Comparator { o1, o2 ->
//            val order1 = o1 + o2
//            val order2 = o2 + o1
//            order2.compareTo(order1)
//        })
//        return ans.joinToString("")
//    }
}