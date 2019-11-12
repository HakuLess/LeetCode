package leetcode.normal

import leetcode.contest.utils.print
import java.util.Stack


fun main(args: Array<String>) {
    val s = Solution32()
    s.longestValidParentheses(")()())").print()
    s.longestValidParentheses("(()").print()
    s.longestValidParentheses("(()())").print()
}

class Solution32 {
    fun longestValidParentheses(s: String): Int {
        var ans = 0
        val stack = Stack<Int>()
        stack.push(-1)
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.push(i)
            } else {
                stack.pop()
                if (stack.empty()) {
                    stack.push(i)
                } else {
                    ans = maxOf(ans, i - stack.peek())
                }
            }
        }
        return ans
    }
    
//    fun longestValidParentheses(s: String): Int {
//        var ans = 0
//        var left = 0
//        var right = 0
//        val list = ArrayList<Pair<Int, Int>>()
//        list.add(Pair(0, 0))
//        s.forEach {
//            if (it == '(') {
//                left++
//            } else {
//                right++
//            }
//            list.add(Pair(left, right))
//        }
//        for (i in 0 until list.size) {
//            for (j in i + 1 until list.size) {
//                val l = list[j].first - list[i].first
//                val r = list[j].second - list[i].second
//                if (r > l) {
//                    break
//                }
//                if (l == r) {
//                    ans = maxOf(ans, j - i)
//                }
//            }
//        }
//        return ans
//    }
}