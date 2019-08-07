package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution678()
//    s.checkValidString("()").print()
//    s.checkValidString("(*)").print()
//    s.checkValidString("(*))").print()
//    s.checkValidString("((*))").print()
//    s.checkValidString("(())()())(*))(((((())()*))**))**()(*(()()*)(**(())()**)((**(()(((()()**)())*(*))(())()()*").print()
    s.checkValidString("(*()").print()
}

class Solution678 {
    fun checkValidString(s: String): Boolean {
        var lo = 0
        var hi = 0
        for (c in s.toCharArray()) {
            lo += if (c == '(') 1 else -1
            hi += if (c != ')') 1 else -1
            if (hi < 0) break
            lo = Math.max(lo, 0)
        }
        return lo == 0
    }

//    fun checkValidString(s: String): Boolean {
//        var l = 0
//        var r = 0
//        var x = 0
//        for (i in 0 until s.length) {
//            when {
//                s[i] == '*' -> {
//                    x++
//                }
//                s[i] == '(' -> {
//                    l++
//                }
//                s[i] == ')' -> {
//                    when {
//                        l == 0 -> x--
//                        l > 0 -> l--
//                        else -> return false
//                    }
//                }
//            }
//        }
//        return true
//    }
}