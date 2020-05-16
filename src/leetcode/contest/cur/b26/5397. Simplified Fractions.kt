package leetcode.contest.cur.b26

import leetcode.contest.utils.gcd
import leetcode.contest.utils.print

fun main() {
    val s = Solution5397()
    s.simplifiedFractions(4).forEach {
        it.print()
    }
}

class Solution5397 {
    fun simplifiedFractions(n: Int): List<String> {
        val ans = arrayListOf<String>()
        for (i in 1..n - 1) {
            for (j in i + 1..n) {
                if (gcd(i, j) == 1) {
                    ans.add("$i/$j")
                }
            }
        }
        return ans
    }
}