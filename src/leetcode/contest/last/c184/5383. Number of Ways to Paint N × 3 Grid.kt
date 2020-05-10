package leetcode.contest.last.c184

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5383()
//    s.numOfWays(0).print()
//    s.numOfWays(1).print()
//    s.numOfWays(2).print()
//    s.numOfWays(3).print()
    s.solve(1).print()
    s.solve(2).print()
}

class Solution5383 {
    val mod = 1000000007

    fun solve(A: Int): Int {
        var color3: Long = 6
        var color2: Long = 6
        val temp: Long = 0
        for (i in 2..A) {
            val temp = color3
            color3 = (2 * color3 + 2 * color2) % 1000000007
            color2 = (2 * temp + 3 * color2) % 1000000007
        }
        val num = (color3 + color2) % 1000000007
        return num.toInt()
    }

    fun numOfWays(n: Int): Int {

        println("${c(n, 24)}")
        println("${c(n, 8)}")
        return c(n, 24) - 9 * c(n, 8) + 18 * c(n, 3) + 9 * c(n, 2) - 24
    }

    private fun c(t: Int, n: Int): Int {
        var ans = 1L
        for (i in 1..t) {
            ans *= n
            ans %= mod
        }
        return ans.toInt()
    }

}