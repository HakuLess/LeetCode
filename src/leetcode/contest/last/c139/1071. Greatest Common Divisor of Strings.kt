package leetcode.contest.last.c139

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val a = Solution1071()
    a.gcdOfStrings("ABCABC", "ABC").print()
    a.gcdOfStrings("ABABAB", "ABAB").print()
    a.gcdOfStrings("LEET", "CODE").print()
}

class Solution1071 {
    fun gcdOfStrings(str1: String, str2: String): String {
        var n1 = str1
        var n2 = str2
        while (n1 != n2) {
            if (n1.isEmpty() || n2.isEmpty()) {
                return ""
            }
            if (n1.length > n2.length) {
                n1 = minus(n1, n2)
            } else {
                n2 = minus(n2, n1)
            }
        }
        return n1
    }

    fun minus(str1: String, str2: String): String {
        val ans = str1.indexOf(str2)
        return if (ans != 0) {
            ""
        } else {
            str1.substring(IntRange(str2.length, str1.length - 1))
        }
    }

//    fun gcdOfStrings(str1: String, str2: String): String {
//        var k = 1
//        var ans1 = 0
//        var ans2 = 0
//        for (i in str1.lastIndex downTo 0) {
//            ans1 += (str1[i] - 'A' + 1) * k
//            k *= 26
//        }
//        ans1.print()
//        k = 1
//        for (i in str2.lastIndex downTo 0) {
//            ans2 += (str1[i] - 'A' + 1) * k
//            k *= 26
//            println("ans2, $ans2")
//            println("k, $k")
//        }
//        ans2.print()
//
//        var ans = gcd(ans1, ans2)
//        ans.print()
//        if (ans == 1) {
//            return ""
//        }
//        val sb = StringBuilder()
//        while (ans / 26 != 0) {
//            sb.append('A' + ans / 26 - 1)
//            ans %= 26
//        }
//        sb.append('A' + ans - 1)
//        return sb.toString()
//    }
}