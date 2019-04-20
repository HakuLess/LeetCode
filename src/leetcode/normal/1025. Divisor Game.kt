package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1025()
    s.divisorGame(2).print()
    s.divisorGame(3).print()
    s.divisorGame(4).print()
    s.divisorGame(5).print()
    s.divisorGame(300).print()
}

class Solution1025 {
    fun divisorGame(N: Int): Boolean {
        return N % 2 == 0
    }
}