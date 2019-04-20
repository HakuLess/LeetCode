package leetcode.normal

import java.lang.StringBuilder

fun strWithout3a3b(A: Int, B: Int): String {
    var a = A
    var b = B
    val sum = a + b
    val array = CharArray(2)

    val sb = StringBuilder()
    for (i in 0 until sum) {
        when {
            array[0] == 'a' && array[1] == 'a' -> {
                sb.append('b')
                b--
                array[0] = array[1]
                array[1] = 'b'
            }
            array[0] == 'b' && array[1] == 'b' -> {
                sb.append('a')
                a--
                array[0] = array[1]
                array[1] = 'a'
            }
            a >= b -> {
                sb.append('a')
                a--
                array[0] = array[1]
                array[1] = 'a'
            }
            a < b -> {
                sb.append('b')
                b--
                array[0] = array[1]
                array[1] = 'b'
            }
        }
    }
    return sb.toString()
}