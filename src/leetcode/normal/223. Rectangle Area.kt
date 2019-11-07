package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution223()
    s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2).print()
    s.computeArea(-2, -2, 2, 2, 3, 3, 4, 4).print()
    s.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1).print()
}

class Solution223 {
    fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
        println((C - A) * (D - B) + (G - E) * (H - F))
        return (C - A) * (D - B) + (G - E) * (H - F) -
                if (G <= A || H <= B || E >= C || F >= D)
                    0
                else
                    (minOf(H, D) - maxOf(B, F)) * (minOf(G, C) - maxOf(E, A))
    }
}