package leetcode.normal

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution43()
    s.multiply("123", "456").print()
}

class Solution43 {
    fun multiply(num1: String, num2: String): String {
        return BigInteger(num1).multiply(BigInteger(num2)).toString(10)
    }
}