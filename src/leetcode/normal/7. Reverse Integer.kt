package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution7()
    s.reverse(1534236469).print()
}

class Solution7 {
    fun reverse(x: Int): Int {
        var num = x
        var result = 0
        while (num != 0) {
            val pop = num % 10
            num /= 10
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7) return 0
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8) return 0
            result = result * 10 + pop
        }

        return result
    }
}