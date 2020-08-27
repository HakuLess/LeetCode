package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution779()
    s.kthGrammar(4, 5).print()
}

class Solution779 {
    fun kthGrammar(N: Int, K: Int): Int {
        println("$N, $K")
        if (N == 1 && K == 1) return 0
        val last = kthGrammar(N - 1, (K + 1) / 2)
        return if (last == 1) {
            if (K % 2 == 0) 0 else 1
        } else {
            if (K % 2 == 0) 1 else 0
        }
    }
}