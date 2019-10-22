package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution319()
    s.bulbSwitch(3).print()
    s.bulbSwitch(1).print()
    s.bulbSwitch(357).print()
}

class Solution319 {
    fun bulbSwitch(n: Int): Int {
        return kotlin.math.sqrt(n.toDouble()).toInt()
    }
}