package leetcode.normal

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1003()
    s.isValid("aabcbc").print()
    s.isValid("abcabcababcc").print()
    s.isValid("abccba").print()
    s.isValid("cababc").print()
    s.isValid("bac").print()
}

class Solution1003 {
    fun isValid(S: String): Boolean {

        val stack = Stack<Char>()

        S.forEach {
            stack.push(it)

            if (stack.size > 2) {
                var peek = stack.peek()
                while (peek == 'c') {
                    val item = stack.pop()
                    val p0 = stack.pop()
                    val p1 = stack.pop()

                    if (p0 == 'b' && p1 == 'a') {
                        peek = if (stack.isEmpty()) {
                            'a'
                        } else {
                            stack.peek()
                        }
                    } else {
                        stack.push(p1)
                        stack.push(p0)
                        stack.push(item)
                        break
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}
