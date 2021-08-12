package leetcode.contest.last.c177

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5172()
    s.largestMultipleOfThree(intArrayOf(8, 1, 9)).print()
    s.largestMultipleOfThree(intArrayOf(8, 6, 7, 1, 0)).print()
    s.largestMultipleOfThree(intArrayOf(1)).print()
    s.largestMultipleOfThree(intArrayOf(0, 0, 0)).print()
}

class Solution5172 {
    fun largestMultipleOfThree(digits: IntArray): String {
        val sum = digits.sum()
        val d1 = arrayListOf<Int>()
        val d2 = arrayListOf<Int>()
        val ans = arrayListOf<Int>()
        ans.addAll(digits.toList())
        digits.forEach {
            if (it % 3 == 1) {
                d1.add(it)
            }
            if (it % 3 == 2) {
                d2.add(it)
            }
        }

        if (sum % 3 == 0) {

        } else if (sum % 3 == 1) {
            if (d1.isNotEmpty()) {
                ans.remove(d1.minOrNull()!!)
            } else if (d2.size >= 2) {
                d2.sort()
                ans.remove(d2[0])
                ans.remove(d2[1])
            } else {
                return ""
            }
        } else if (sum % 3 == 2) {
            if (d2.isNotEmpty()) {
                ans.remove(d2.minOrNull()!!)
            } else if (d1.size >= 2) {
                d1.sort()
                ans.remove(d1[0])
                ans.remove(d1[1])
            } else {
                return ""
            }
        }
        if (ans.isEmpty()) {
            return ""
        }
        if (ans.all { it == 0 }) {
            return "0"
        }
        ans.sortDescending()
        return ans.joinToString("")
    }
}