package leetcode.contest.last.c144

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1111()
    s.maxDepthAfterSplit("(()())").print()
    s.maxDepthAfterSplit("()(())()").print()
}

class Solution1111 {
    fun maxDepthAfterSplit(seq: String): IntArray {
        val stack = Stack<Char>()
        val ans = arrayListOf<Int>()
        seq.forEach {
            when (it) {
                '(' -> {
                    stack.push(it)
                    ans.add(stack.size)
                }
                ')' -> {
                    ans.add(stack.size)
                    stack.pop()
                }
            }
        }

        val max = ans.max()!!
        val res = ans.map {
            if (it > max / 2) {
                1
            } else {
                0
            }
        }
        return res.toIntArray()
    }
}