package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution686()
    s.repeatedStringMatch("aa", "a").print()
}

class Solution686 {
    fun repeatedStringMatch(A: String, B: String): Int {
        var q = 1
        val s = StringBuilder(A)
        while (s.length < B.length) {
            s.append(A)
            q++
        }
        if (s.indexOf(B) >= 0) {
            return q
        }
        return if (s.append(A).indexOf(B) >= 0) q + 1 else -1
    }
//    fun repeatedStringMatch(A: String, B: String): Int {
//        val a = A.length
//        val b = B.length
//        if (a >= b) {
//            a
//        }
//        var start = -1
//        for (i in 0 until a) {
//            if (A == B.substring(i, i + a)) {
//                start = i
//                break
//            }
//        }
//        if (start == -1) {
//            return -1
//        }
//        var ans = 0
//        if (start != 0) {
//            ans++
//            // before
//            if (!A.endsWith(B.substring(0, start))) {
//                return -1
//            }
//        }
//
//        // center
//        while (start + a < B.length) {
//            if (A != B.substring(start, start + a)) {
//                return -1
//            }
//            ans++
//            start += a
//        }
//
//        if (start != B.length) {
//            ans++
//            // after
//            if (!A.startsWith(B.substring(start))) {
//                return -1
//            }
//        }
//
//        return ans
//
//    }
}