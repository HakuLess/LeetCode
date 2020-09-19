package leetcode.contest.cur.`2020`.q4

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solutionq4()
    s.keyboard(1, 1).print()
    s.keyboard(1, 2).print()
//    val cur = System.currentTimeMillis()
    s.keyboard(5, 130).print()
//    println(System.currentTimeMillis() - cur)
}

class Solutionq4 {
    fun keyboard(k: Int, n: Int): Int {
        val mod = (1e9 + 7).toLong().toBigInteger()
        val cur = IntArray(k + 1)
        cur[0] = 26

        val seen = hashMapOf<String, BigInteger>()
        fun dfs(left: Int, cur: IntArray): BigInteger {
//            cur.print()
            if (left == 0) return BigInteger.ONE
            val key = cur.joinToString()
            if (key in seen) {
                return seen[key]!!
            }
            var ans = BigInteger.ZERO
            for (i in 0 until k) {
                if (cur[i] > 0) {
                    cur[i]--
                    cur[i + 1]++
                    ans += dfs(left - 1, cur).multiply((cur[i] + 1).toBigInteger())
                    cur[i]++
                    cur[i + 1]--
                }
            }
            return ans.also {
                seen[key] = it
            }
        }
        return dfs(n, cur).mod(mod).toInt()
    }

//    fun keyboard(k: Int, n: Int): Int {
//        val mod = (1e9 + 7).toLong().toBigInteger()
//        val cur = IntArray(5)
//
//        val seen = hashMapOf<String, BigInteger>()
//        fun dfs(left: Int, cur: IntArray): BigInteger {
//            if (left == 0) return BigInteger.ONE
//            val key = cur.sorted().joinToString()
//            if (key in seen) {
//                return seen[key]!!
//            }
//            var ans = BigInteger.ZERO
//            for (i in 0 until 26) {
//                if (cur[i] < k) {
//                    cur[i]++
//                    ans += dfs(left - 1, cur)
//                    cur[i]--
//                }
//            }
//            return ans.also {
//                seen[key] = it.mod(mod)
//            }
//        }
//        return dfs(n, cur).mod(mod).toInt()
//    }
}