package leetcode

import java.lang.StringBuilder

fun rangeBitwiseAnd(m: Int, n: Int): Int {

    val str0 = Integer.toBinaryString(m)
    val str1 = Integer.toBinaryString(n)

    if (str1.length != str0.length) {
        return 0
    }

    val ans = StringBuilder()
    var before = true
    for (i in 0 until str0.length) {
        if (before && str0[i] == str1[i]) {
            ans.append(str0[i])
        } else {
            before = false
            ans.append(0)
        }
    }

    var res = 0
    var step = 1
    ans.toString().reversed().forEach {
        res += (it - '0') * step
        step *= 2
    }
    return res
}