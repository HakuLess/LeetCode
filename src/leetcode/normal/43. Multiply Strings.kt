package leetcode.normal

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution43()
    s.multiply("123", "456").print()
}

class Solution43 {
    fun multiply(num1: String, num2: String): String {
        val a = BigInteger(num1)
        val b = BigInteger(num2)
        return a.multiply(b).toString(10)
    }
}