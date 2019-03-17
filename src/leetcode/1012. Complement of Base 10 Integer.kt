package leetcode

fun main(args: Array<String>) {
    val s = Solution1012()
    s.bitwiseComplement(10).print()
    s.bitwiseComplement(5).print()
    s.bitwiseComplement(7).print()
}

class Solution1012 {
    fun bitwiseComplement(N: Int): Int {
        val s = Integer.toBinaryString(N)
        val sum = Math.pow(2.0, s.length.toDouble()) - 1
        println("$s, $sum")
        return (sum - N).toInt()
    }
}