package leetcode.normal

import leetcode.print
import java.lang.Math.abs
import java.lang.StringBuilder


fun main(args: Array<String>) {
    addBinary("1010", "11111").print()
}

fun addBinary(a: String, b: String): String {
    var reverseA = a.reversed()
    var reverseB = b.reversed()

    val sb = StringBuilder()
    for (i in 0 until abs(reverseA.length - reverseB.length)) {
        sb.append("0")
    }
    if (reverseA.length < reverseB.length) {
        reverseA += sb.toString()
    } else {
        reverseB += sb.toString()
    }

    val result = StringBuilder()
    var up = false
    for (i in 0 until reverseA.length) {
        when {
            reverseA[i] == '0' && reverseB[i] == '0' -> {
                up = if (up) {
                    result.append("1")
                    false
                } else {
                    result.append("0")
                    false
                }
            }
            reverseA[i] == '1' && reverseB[i] == '0' -> {
                result.append(if (up) "0" else "1")
            }
            reverseA[i] == '0' && reverseB[i] == '1' -> {
                result.append(if (up) "0" else "1")
            }
            reverseA[i] == '1' && reverseB[i] == '1' -> {
                up = if (up) {
                    result.append("1")
                    true
                } else {
                    result.append("0")
                    true
                }
            }
        }
    }
    if (up) {
        result.append("1")
    }
    return result.toString().reversed()
}