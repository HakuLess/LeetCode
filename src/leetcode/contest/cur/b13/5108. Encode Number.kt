package leetcode.contest.cur.b13

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5108()
    s.encode(23).print()
}

class Solution5108 {
    fun encode(num: Int): String {
        return (num + 1).toString(2).substring(1)
    }
//    fun encode(num: Int): String {
//        if (num == 0) {
//            return ""
//        }
//        var it = num + 1
//        var ans = ""
//        while (it > 1) {
//            ans = ('0' + it % 2) + ans
//            it /= 2
//        }
//        return ans
//    }
}