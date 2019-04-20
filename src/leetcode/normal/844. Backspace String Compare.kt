package leetcode.normal

import java.util.*

fun backspaceCompare(S: String, T: String): Boolean {
    val s1 = Stack<Char>()
    val s2 = Stack<Char>()

    S.forEach {
        if (it == '#') {
            if (s1.isNotEmpty()) {
                s1.pop()
            }
        } else {
            s1.push(it)
        }
    }

    T.forEach {
        if (it == '#') {
            if (s2.isNotEmpty()) {
                s2.pop()
            }
        } else {
            s2.push(it)
        }
    }

    if (s1.size != s2.size) {
        return false
    }
    for (i in 0 until s1.size) {
        if (s1.pop() != s2.pop()) {
            return false
        }
    }
    return true
}