package leetcode.normal

import java.lang.StringBuilder

class Solution415 {
    fun addStrings(num1: String, num2: String): String {
        var isAdd = false
        val l1 = num1.length
        val l2 = num2.length
        val s1 = if (l1 < l2) {
            num1.reversed()
        } else {
            num2.reversed()
        }
        val s2 = if (l1 < l2) {
            num2.reversed()
        } else {
            num1.reversed()
        }

        val sb = StringBuilder()
        for (i in s1.indices) {
            val it = (s1[i] - '0') + (s2[i] - '0') + if (isAdd) {
                1
            } else {
                0
            }

            isAdd = if (it >= 10) {
                sb.append(it - 10)
                true
            } else {
                sb.append(it)
                false
            }
        }

        for (j in s1.length until s2.length) {
            val it = (s2[j] - '0') + if (isAdd) {
                1
            } else {
                0
            }
            isAdd = if (it >= 10) {
                sb.append(it - 10)
                true
            } else {
                sb.append(it)
                false
            }
        }
        if (isAdd) {
            sb.append('1')
        }

        return sb.toString().reversed()
    }
}