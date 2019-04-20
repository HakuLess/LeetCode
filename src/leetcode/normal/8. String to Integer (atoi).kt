package leetcode.normal

import leetcode.print
import java.lang.StringBuilder

//todo not finished
fun main(args: Array<String>) {
    val s = Solution8()
    s.myAtoi(" -42").print()
    s.myAtoi(" 4193 with words").print()
    s.myAtoi(" -91283472332").print()
    s.myAtoi(" words and 987").print()
}

class Solution8 {
    fun myAtoi(str: String): Int {
        var signed = false
        val s = StringBuilder()
        var plus = true
        val res = str.trim()
        for (i in 0 until res.length) {
            if (res[i] == '+' || res[i] == '-') {
                if (signed || i != 0) {
                    break
                } else {
                    signed = true
                    s.append(res[i])
                    if (res[i] == '-') {
                        plus = false
                    }
                }
            } else if (res[i] in '0'..'9') {
                s.append(res[i])
            } else {
                break
            }
        }

        if (s.isEmpty() || s.none { it in '0'..'9' }) {
            return 0
        }

        return try {
            Integer.parseInt(s.toString())
        } catch (ex: Exception) {
            if (plus) {
                2147483647
            } else {
                -2147483648
            }
        }
    }
}