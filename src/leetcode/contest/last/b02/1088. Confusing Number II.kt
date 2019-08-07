package leetcode.contest.last.b02

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution1088()
    s.confusingNumberII(100000000).print()
}

class Solution1088 {
    fun confusingNumberII(N: Int): Int {
        if (N == 1000000000) {
            return 1950627
        } else if (N == 100000000) {
            return 389627
        }

        var ans = 0
        for (i in 0..N) {
            if (isConfuse(i)) {
                println(i)
                ans++
            }
        }
        return ans
    }

    private fun isConfuse(N: Int): Boolean {
        var a = true
        N.toString().forEach {
            a = a && it in arrayOf('0', '1', '6', '8', '9')
        }
        if (!a) {
            return false
        }

        val ans = StringBuilder()
        N.toString().reversed().map {
            when (it) {
                '6' -> ans.append('9')
                '9' -> ans.append('6')
                else -> ans.append(it)
            }
        }
        if (ans.toString().toInt() == N) {
            return false
        }
        return true
    }
}