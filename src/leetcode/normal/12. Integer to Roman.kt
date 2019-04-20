package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    intToRoman(1994).print()
}

fun intToRoman(num: Int): String {
    var count = num
    val sb = StringBuilder()
    while (count >= 1000) {
        sb.append('M')
        count -= 1000
    }
    while (count >= 500) {
        sb.append('D')
        count -= 500
    }
    while (count >= 100) {
        sb.append('C')
        count -= 100
    }
    while (count >= 50) {
        sb.append('L')
        count -= 50
    }
    while (count >= 10) {
        sb.append('X')
        count -= 10
    }
    while (count >= 5) {
        sb.append('V')
        count -= 5
    }
    while (count >= 1) {
        sb.append('I')
        count -= 1
    }

    sb.toString().print()

    return sb.toString()
            .replace("VIIII", "IX")
            .replace("IIII", "IV")
            .replace("LXXXX", "XC")
            .replace("XXXX", "XL")
            .replace("DCCCC", "CM")
            .replace("CCCC", "CD")


}