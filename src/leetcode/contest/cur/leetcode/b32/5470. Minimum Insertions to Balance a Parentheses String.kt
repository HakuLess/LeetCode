package leetcode.contest.cur.leetcode.b32

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5479()
    s.minInsertions("(()))(()))()())))").print()
}

class Solution5479 {
    fun minInsertions(s: String): Int {
        var ans = 0
        var cur = 0
        var i = 0
        while (i < s.length) {
            if (s[i] == '(') cur++
            else {
                if (i < s.length - 1 && s[i + 1] == ')') i++
                else ans++
                if (cur > 0) cur-- else ans++
            }
            i++
        }
        ans += cur * 2
        return ans
    }

//    fun minInsertions(s: String): Int {
//        var cur = 0
//        var ans = 0
//        s.forEach {
//            if (it == '(') {
//                cur += 2
//            } else {
//                if (cur == 0) {
//                    cur += 2
//                    ans++
//                }
//                cur--
//            }
//        }
//        ans += cur
//        return ans
//    }
}