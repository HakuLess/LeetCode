package leetcode.contest.cur.leetcode.c213

import leetcode.contest.utils.print
import java.lang.StringBuilder
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5600()
    s.kthSmallestPath(intArrayOf(2, 3), 1).print()
    s.kthSmallestPath(intArrayOf(2, 3), 2).print()
    s.kthSmallestPath(intArrayOf(15, 15), 1).print()
}

class Solution5600 {
    fun kthSmallestPath(destination: IntArray, k: Int): String {
        return GFG.Ksmallest(destination[1], destination[0], (k - 1).toBigInteger(), StringBuilder()).toString()
    }

    object GFG {
        fun factorial(a: Int, b: Int): BigInteger {
            var res = 1.toBigInteger()
            for (i in 1..a + b) res *= i.toBigInteger()
            for (i in 1..a) res /= i.toBigInteger()
            for (i in 1..b) res /= i.toBigInteger()
            return res
        }

        fun Ksmallest(x: Int, y: Int, k: BigInteger, ans: StringBuilder): StringBuilder {
            var x = x
            var y = y
            if (x == 0 && y == 0) return ans
            else if (x == 0) {
                y--
                ans.append("V")
                Ksmallest(x, y, k, ans)
            } else if (y == 0) {
                x--
                ans.append("H")
                Ksmallest(x, y, k, ans)
            } else {
                if (factorial(x - 1, y) > k) {
                    ans.append("H")
                    Ksmallest(x - 1, y, k, ans)
                } else {
                    ans.append("V")
                    Ksmallest(x, y - 1, k - factorial(x - 1, y), ans)
                }
            }
            return ans
        }
    }
}