package leetcode.contest.last.c179

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5353()
    s.numTimesAllBlue(intArrayOf(2, 1, 3, 5, 4)).print()
//    s.numTimesAllBlue(intArrayOf(3, 2, 4, 1, 5)).print()
}

class Solution5353 {
    fun numTimesAllBlue(light: IntArray): Int {
        var max = 0
        var ans = 0
        light.forEachIndexed { index, i ->
            max = maxOf(max, i)
            if (max == index + 1)
                ans++
        }
        return ans
    }
//    fun numTimesAllBlue(light: IntArray): Int {
//        val s = IntArray(light.size) { 0 }
//        var ans = 0
//        light.forEachIndexed { index, i ->
//            s[i - 1] = 1
//            if (check(s, index)) {
//                println("add")
//                ans++
//            }
//        }
//        return ans
//    }
//
//    private fun check(s: IntArray, i: Int): Boolean {
//        for (j in 0..i) {
//            if (s[j] == 0) {
//                return false
//            }
//        }
//        return true
//    }
}