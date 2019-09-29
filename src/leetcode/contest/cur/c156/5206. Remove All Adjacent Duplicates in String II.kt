package leetcode.contest.cur.c156

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5206()
    s.removeDuplicates("pbbcggttciiippooaais", 2).print()
    s.removeDuplicates("deeedbbcccbdaa", 3).print()
    s.removeDuplicates("abcd", 2).print()
}

class Solution5206 {
    fun removeDuplicates(s: String, k: Int): String {
        var need = false
        val stack = Stack<Char>()
        var curChar = ' '
        var curCount = 0
        s.forEach {
            stack.add(it)
            if (it == curChar) {
                curCount++
            } else {
                curChar = it
                curCount = 1
            }
            if (curCount == k) {
                need = true
                for (i in 0 until k) {
                    stack.pop()
                }
            }
        }
        val ans: String
        ans = if (need) {
            removeDuplicates(stack.joinToString(""), k)
        } else {
            stack.joinToString("")
        }
        return ans
    }
}