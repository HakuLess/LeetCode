package leetcode.contest.cur.leetcode.c233

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5711()
    s.maxValue(4, 2, 6).print()
    s.maxValue(6, 1, 10).print()
    s.maxValue(1, 0, 24).print()
}

class Solution5711 {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        fun check(c: Long): Boolean? {
            var min = 0L
            var max = 0L
            if (c < index + 1) {
                min += (c + 1) * c / 2 + (index + 1 - c)
            } else {
                min += (c + c - index) * (index + 1) / 2
            }
            max += (c + c + index) * (index + 1) / 2
//            min.print()
            if (n - index < c) {
//                println("$c $n $index: ${(c + c - n + index + 1)}")
                min += (c + c - n + index + 1) * (n - index) / 2
            } else {
                min += (c + 1) * c / 2 + (n - index - c)
            }
            min -= c
//            println("$c $n $index: ${(c + c + n - index - 1) * (n - index) / 2}")
            max += (c + c + n - index - 1) * (n - index) / 2
            max -= c
            return (if (maxSum in min..max) {
                true
            } else if (maxSum < min) {
                false
            } else {
                null
            }).also {
//                println("$c: $min $max $it")
            }
        }

        var left = 1
        var right = maxSum
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when(check(mid.toLong())) {
                null -> left = mid
                true -> left = mid
                else -> right = mid
            }
        }
        return if (check(right.toLong()) == true) {
            right
        } else {
            left
        }
    }
}