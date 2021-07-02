package leetcode.normal

import java.lang.StringBuilder

class Solution415 {
    fun addStrings(num1: String, num2: String): String {
        var carry = 0
        var i = num1.length - 1
        var j = num2.length - 1
        val sb = StringBuilder()
        while (i >= 0 || j >= 0 || carry != 0) {
            val v1 = if (i >= 0) num1[i--] - '0' else 0
            val v2 = if (j >= 0) num2[j--] - '0' else 0
            sb.append((v1 + v2 + carry) % 10)
            carry = (v1 + v2 + carry) / 10
        }
        return sb.reverse().toString()
    }
}