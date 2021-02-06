package leetcode.normal

import java.util.*

class Solution917 {
    fun reverseOnlyLetters(S: String): String {
        var result = ""
        val stack: Stack<Char> = Stack()
        S.forEach {
            if (it.isLetter()) {
                stack.push(it)
            }
        }
        S.forEach {
            result += if (it.isLetter()) {
                stack.pop()
            } else {
                it
            }
        }
        return result
    }
}