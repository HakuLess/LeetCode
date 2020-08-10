package leetcode.contest.cur.leetcode.c201

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main() {
    val s = Solution5484()
    s.findKthBit(3, 1).also { println(it) }
//    s.findKthBit(20, 3000).also { println(it) }
}

class Solution5484 {
    fun findKthBit(n: Int, k: Int): Char {
        var s = "0"
        while (s.length < k) {
            s = s + "1" + reverse(s)
            s.print()
        }
        return s[k - 1]
    }

    private fun reverse(s: String): String {
        val ans = StringBuilder("")
        s.reversed().forEach {
            if (it == '1') ans.append('0')
            else ans.append('1')
        }
        return ans.toString()
    }
//    fun findKthBit(n: Int, k: Int): Char {
//        fun dfs(n: Int): Int {
//            if (n == 1) return 0
//            val index = ceil(log(n + 1).toDouble())
//            val l = (2.0.pow(index) - 1).toInt()
//            return if (n == (l + 1) / 2) {
//                1
//            } else {
//                1 xor dfs(l + 1 - n)
//            }
//        }
//        return dfs(k).toString()[0]
//    }
//
//    private fun log(n: Int): Int {
//        var ans = 0
//        var cur = 1
//        while (cur < n) {
//            cur *= 2
//            ans++
//        }
//        return ans
//    }
}