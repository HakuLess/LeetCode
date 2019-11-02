package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution12()
    s.intToRoman(1994).print()
}

class Solution12 {
    fun intToRoman(num: Int): String {
        val intArr = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val romaArr = arrayListOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var ans = ""
        var cur = num
        var index = 0
        while (index < 13) {
            while (cur >= intArr[index]) {
                ans += romaArr[index]
                cur -= intArr[index]
            }
            index++
        }
        return ans
    }
}