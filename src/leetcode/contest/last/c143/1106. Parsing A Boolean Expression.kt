package leetcode.contest.last.c143

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1106()
//    s.parseBoolExpr("!(f)").print()
//    s.parseBoolExpr("|(f,t)").print()
//    s.parseBoolExpr("&(t,f)").print()
//    s.parseBoolExpr("|(&(t,f,t),!(t))").print()
//    s.parseBoolExpr("!(&(!(t),&(f),|(f)))").print()
    s.parseBoolExpr("!(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))))").print()
}

class Solution1106 {
    fun parseBoolExpr(expression: String): Boolean {
        val mark = Stack<Char>()
        val para = Stack<Char>()
        var ans = 'a'
        for (i in 0 until expression.length) {
            when (expression[i]) {
                '(' -> {
                    para.push('(')
                }
                ')' -> {
                    val m = mark.pop()
                    println(m)
                    ans = if (m == '&') {
                        val list = arrayListOf<Char>()
                        while (para.peek() != '(') {
                            list.add(para.pop())
                        }
                        para.pop()
                        if (list.all { it == 't' }) {
                            't'
                        } else {
                            'f'
                        }
                    } else if (m == '|') {
                        val list = arrayListOf<Char>()
                        while (para.peek() != '(') {
                            list.add(para.pop())
                        }
                        para.pop()
                        if (list.any { it == 't' }) {
                            't'
                        } else {
                            'f'
                        }
                    } else {
                        val p1 = para.pop()
                        para.pop()
                        if (p1 == 't') {
                            'f'
                        } else {
                            't'
                        }
                    }
                    para.push(ans)
                }
                '&' -> {
                    mark.push('&')
                }
                '|' -> {
                    mark.push('|')
                }
                '!' -> {
                    mark.push('!')
                }
                't' -> {
                    para.push('t')
                }
                'f' -> {
                    para.push('f')
                }
                ',' -> {

                }
            }
        }
        return ans == 't'
    }
}