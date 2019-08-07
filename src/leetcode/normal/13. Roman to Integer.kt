package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    romanToInt("MCMXCIV").print()
}

fun romanToInt(s: String): Int {
    val res = s.replace("IX", "VIIII")
            .replace("IV", "IIII")
            .replace("XC", "LXXXX")
            .replace("XL", "XXXX")
            .replace("CM", "DCCCC")
            .replace("CD", "CCCC")
    var result = 0
    for (re in res) {
        when (re) {
            'M' -> result += 1000
            'D' -> result += 500
            'C' -> result += 100
            'L' -> result += 50
            'X' -> result += 10
            'V' -> result += 5
            'I' -> result += 1
        }
    }
    return result
}