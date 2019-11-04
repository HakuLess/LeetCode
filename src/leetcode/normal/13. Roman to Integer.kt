package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution13()
    s.romanToInt("MCMXCIV").print()
}

class Solution13 {

    fun romanToInt(s: String): Int {
        val charArray = s.toCharArray()
        var preVal = 0
        var sum = 0
        for (i in charArray.size - 1 downTo 0) {
            var value = 0
            when (charArray[i]) {
                'I' -> value = 1
                'V' -> value = 5
                'X' -> value = 10
                'L' -> value = 50
                'C' -> value = 100
                'D' -> value = 500
                'M' -> value = 1000
            }
            if (value >= preVal) {
                sum += value
            } else {
                sum -= value
            }
            preVal = value
        }
        return sum
    }
//    fun romanToInt(s: String): Int {
//        val res = s.replace("IX", "VIIII")
//                .replace("IV", "IIII")
//                .replace("XC", "LXXXX")
//                .replace("XL", "XXXX")
//                .replace("CM", "DCCCC")
//                .replace("CD", "CCCC")
//        var result = 0
//        for (re in res) {
//            when (re) {
//                'M' -> result += 1000
//                'D' -> result += 500
//                'C' -> result += 100
//                'L' -> result += 50
//                'X' -> result += 10
//                'V' -> result += 5
//                'I' -> result += 1
//            }
//        }
//        return result
//    }
}