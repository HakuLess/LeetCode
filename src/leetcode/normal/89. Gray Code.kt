package leetcode.normal

import kotlin.math.pow

fun main(args: Array<String>) {
    val s = Solution89()
    s.grayCode(3).forEach { print("$it, ") }
    println()
}

class Solution89 {
    fun grayCode(n: Int): List<Int> {
        val ans = arrayListOf(0)
        if (n == 0) {
            return ans
        }
        var k = 1
        while (k <= n) {
            ans.addAll(ArrayList(ans).reversed().map {
                (it + 2.toDouble().pow(k - 1)).toInt()
            })
            k++
        }
        return ans
    }
}