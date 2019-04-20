package leetcode.normal

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val str = "Test1ng-Leet=code-Q!"
    reverseOnlyLetters(str).print()
}

fun reverseOnlyLetters(S: String): String {
    var result = ""
    val stack : Stack<Char> = Stack()
    S.forEach {
        if (isLetter(it)) {
            stack.push(it)
        }
    }

    S.forEach {
        result += if (isLetter(it)) {
            stack.pop()
        } else {
            it
        }
    }

    return result
}

fun isLetter(c: Char): Boolean {
    if (c in 'a'..'z' || c in 'A'..'Z') {
        return true
    }
    return false
}