package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1022()
//    s.smallestRepunitDivByK(3).print()
//    s.smallestRepunitDivByK(1).print()
//    s.smallestRepunitDivByK(2).print()
    s.smallestRepunitDivByK(5).print()
    s.smallestRepunitDivByK(17).print()
    s.smallestRepunitDivByK(23).print()
    s.smallestRepunitDivByK(18367).print()
    s.smallestRepunitDivByK(99999).print()
    s.smallestRepunitDivByK(19927).print()
}

class Solution1022 {
    fun smallestRepunitDivByK(K: Int): Int {
        if (K % 5 == 0 || K % 2 == 0) {
            return -1
        }
        var sum = 1
        for (i in 0 until 100000) {
//            println(sum)
            if (sum % K == 0) {
                return i + 1
            }
            sum = (sum * 10 + 1) % K
        }

        return -1
    }
    
//    fun smallestRepunitDivByK(K: Int): Int {
//        if (K % 5 == 0 || K % 2 == 0) {
//            return -1
//        }
//        var sum = BigInteger.valueOf(1L)
//        for (i in 0 until 100000) {
////            println(sum)
//            if (sum % BigInteger.valueOf(K.toLong()) == BigInteger.ZERO) {
//                return i + 1
//            }
//            sum = sum.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(1))
//        }
//
//        return -1
//    }
}