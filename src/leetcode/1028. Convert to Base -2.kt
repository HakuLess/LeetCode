package leetcode

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution1028()
//    s.baseNeg3(5).print()
//    s.baseNeg2(2).print()
    s.baseNeg2(6).print()
//    s.baseNeg2(3).print()
//    s.baseNeg2(4).print()
//    s.baseNeg2(0).print()
//    s.baseNeg2(1).print()
}

class Solution1028 {

    fun baseNeg2(N: Int): String {
        return baseNegK(N, -2)
    }

    fun baseNegK(N: Int, K: Int): String {
        var n = N
        if (n == 0) return "0"
        val sb = StringBuilder()

        while (n != 0) {
            var r = n % K
            n /= K
            println("$r, $n")

            if (r < 0) {
                r -= K
                n++
            }
            sb.append(r)
        }
        return sb.reverse().toString()
    }
//    fun baseNeg2(N: Int): String {
//        if (N == 0) {
//            return "0"
//        }
//        val str = Integer.toBinaryString(N)
//        val list = arrayListOf<Int>()
//        list.add(0)
//        list.add(0)
//        str.forEach {
//            list.add(it - '0')
//        }
//
//        for (i in list.lastIndex downTo 0) {
//            if (list[i] == 2) {
//                list[i - 1]++
//                list[i] = 0
//            }
//            if ((list.lastIndex - i) % 2 != 0) {
//                println("$i, ${list[i]}")
//                if (list[i] == 1) {
//                    list[i - 1]++
//                }
//            }
//
//        }
//
//        val ans = StringBuilder()
//        list.forEach {
//            ans.append(it)
//        }
//        return ans.trimStart('0').toString()
//    }
}