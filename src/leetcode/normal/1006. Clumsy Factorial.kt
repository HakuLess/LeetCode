package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1006()
    s.clumsy(4).print()
    s.clumsy(8).print()
    s.clumsy(10).print()
//    s.clumsy(6744).print()
}

class Solution1006 {
    fun clumsy(N: Int): Int {
        return when (N) {
            1 -> 1
            2 -> 2 * 1
            3 -> 3 * 2 / 1
            4 -> 4 * 3 / 2 + 1
            5 -> 5 * 4 / 3 + 2 - 1
            6 -> 6 * 5 / 4 + 3 - 2 * 1
            7 -> 7 * 6 / 5 + 4 - 3 * 2 / 1
            8 -> 8 * 7 / 6 + 5 - 4 * 3 / 2 + 1
            else -> {
                N * (N - 1) / (N - 2) + (N - 3) - (N - 4) * (N - 5) / (N - 6) * 2 + clumsy(N - 4)
            }
        }
    }
}