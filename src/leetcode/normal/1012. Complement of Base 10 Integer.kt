package leetcode.normal

import leetcode.contest.utils.print
import kotlin.math.pow

fun main(args: Array<String>) {
    val s = Solution1012()
    s.bitwiseComplement(10).print()
    s.bitwiseComplement(5).print()
    s.bitwiseComplement(7).print()
}

class Solution1012 {
    fun bitwiseComplement(N: Int): Int {
        val s = Integer.toBinaryString(N)
        val sum = 2.0.pow(s.length.toDouble()) - 1
        println("$s, $sum")
        return (sum - N).toInt()
    }
}