package leetcode.contest.cur.leetcode.b54

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5770()
//    s.minOperationsToFlip("(((0)&1&((0&0))))").print()
//    s.minOperationsToFlip("1&(0|1)").print()
//    s.minOperationsToFlip("(0&0)&(0&0&0)").print()
//    s.minOperationsToFlip("(0|(1|0&1))").print()
    s.minOperationsToFlip("((0&(0&0)&(0|(0)&1&0)))").print()
}

class Solution5770 {
    // 操作符 && 栈
    fun minOperationsToFlip(expression: String): Int {
        val states = Stack<Pair<Int, Int>>()
        val ops = Stack<Char>()
        for (c in expression) {
            if (c in "01)") {
                when (c) {
                    '0' -> states.push(Pair(0, 1))
                    '1' -> states.push(Pair(1, 0))
                    else -> ops.pop()
                }
                if (ops.isNotEmpty() && ops.peek() != '(') {
                    val op = ops.pop()
                    val (p0, p1) = states.pop()
                    val (q0, q1) = states.pop()
                    if (op == '&')
                    // and 操作
                    // 状态变化成0，取两边为0中的较小值
                    // 状态变化成1，取两位均为1 or 一边为1+改变操作符
                        states.push(Pair(minOf(q0, p0), minOf(q1 + p1, 1 + minOf(q1, p1))))
                    else
                    // or 操作
                    // 状态变化成0，取两边均为0 or 一边为0+改变操作符
                    // 状态变化成1，取两边为1中的较小值
                        states.push(Pair(minOf(q0 + p0, 1 + minOf(q0, p0)), minOf(q1, p1)))
                }
            } else {
                ops.push(c)
            }
        }
        return states.peek().let { maxOf(it.first, it.second) }
    }
}