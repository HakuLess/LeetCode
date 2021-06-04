package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution481()
    s.magicalString(4).print()
}

class Solution481 {
    fun magicalString(n: Int): Int {
        var index = 1
        val s = StringBuilder()
        s.append(1)
        while (s.length < n) {
            if (index == s.length) {
                s.append(if (s.last() == '1') 22 else 1)
                index++
            } else {
                if (s.last() == '1') {
                    s.append(if (s[index++] == '1') 2 else 22)
                } else {
                    s.append(if (s[index++] == '1') 1 else 11)
                }
            }
        }
        s.toString().print()
        return s.take(n).count { it == '1' }
    }
}