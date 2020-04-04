package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution202()
    s.isHappy(2).print()
}

class Solution202 {
    var source = hashSetOf<Int>()

    fun isHappy(n: Int): Boolean {
        if (n in source) {
            return false
        }
        source.add(n)
        var b = 0
        n.toString().forEach {
            val i = it - '0'
            b += i * i
        }
        return if (b == 1) {
            true
        } else {
            isHappy(b)
        }
    }
}
