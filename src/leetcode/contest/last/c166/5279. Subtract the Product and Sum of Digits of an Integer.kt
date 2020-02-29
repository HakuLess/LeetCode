package leetcode.contest.last.c166

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5279()
    s.subtractProductAndSum(234).print()
    s.subtractProductAndSum(4421).print()
}
class Solution5279 {
    fun subtractProductAndSum(n: Int): Int {
        var cur = n
        var a = 0
        var b = 1
        while (cur != 0) {
            a += cur % 10
            b *= cur % 10
            cur /= 10
        }
        return b - a
    }
}