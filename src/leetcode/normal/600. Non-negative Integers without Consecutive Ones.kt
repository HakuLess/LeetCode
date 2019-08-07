package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution600()
//    s.findIntegers(19).print()
//    s.findIntegers(17).print()
    s.findIntegers(7).print()
//    s.findIntegers(9).print()
    s.findIntegers(133).print()
}

class Solution600 {

//    fun findIntegers(num: Int): Int {
//        val f = IntArray(32)
//        f[0] = 1
//        f[1] = 2
//        for (i in 2 until f.size)
//            f[i] = f[i - 1] + f[i - 2]
//        var i = 30
//        var sum = 0
//        var pre = 0
//
//        while (i >= 0) {
//            if (num and (1 shl i) != 0) {
//                sum += f[i]
//                println(sum)
//                if (pre == 1) {
//                    sum--
//                    break
//                }
//                pre = 1
//            } else
//                pre = 0
//            i--
//        }
//        return sum + 1
//    }

    fun findIntegers(num: Int): Int {
        if (num == 0) {
            return 0
        }
        if (num == 1) {
            return 2
        }

        val b = Integer.toBinaryString(num)
        val n = b.length

        val dp = IntArray(n)
        dp[0] = 1
        dp[1] = 2
        for (i in 2 until n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        var ans = 0
        var pre = '0'
        for (i in 0 until n) {
            if (b[i] == '1') {
                ans += dp[n - i - 1]
                if (pre == '1') {
                    ans--
                    break
                }
            }
            pre = b[i]
        }

        return ans + 1
    }
}