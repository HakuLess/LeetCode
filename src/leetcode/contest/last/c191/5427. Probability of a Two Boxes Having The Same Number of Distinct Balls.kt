package leetcode.contest.last.c191

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5427()
//    s.getProbability(intArrayOf(1, 1)).print()
//    s.getProbability(intArrayOf(2, 1, 1)).print()
//    s.getProbability(intArrayOf(1, 2, 1, 2)).print()
//    s.getProbability(intArrayOf(3, 2, 1)).print()
    s.getProbability(intArrayOf(6, 6, 6, 6, 6, 6)).print()
}

class Solution5427 {
    var type = 0
    var ans = BigInteger.ZERO
    fun getProbability(balls: IntArray): Double {
        val cur = IntArray(balls.size)
        val sum = balls.product().toDouble()
        helper(cur, balls, 0)
        return ans.toDouble() / sum
    }

    private fun helper(cur: IntArray, balls: IntArray, pos: Int) {
        if (pos == balls.size) {
            if (cur.sum() == balls.sum() / 2 && check(cur, balls)) {
                ans += cur.product() * (balls - cur).product()
            }
            return
        }
        for (i in 0..balls[pos]) {
            cur[pos] = i
            helper(cur, balls, pos + 1)
        }
    }

    operator fun IntArray.minus(b: IntArray): IntArray {
        val ans = IntArray(this.size)
        for (i in this.indices) {
            ans[i] = this[i] - b[i]
        }
        return ans
    }

    private fun IntArray.product(): BigInteger {
        var ans = fact(this.sum())
        this.forEach {
            if (it != 0) {
                ans /= fact(it)
            }
        }
        return ans
    }

    private val factMap = HashMap<Int, BigInteger>()
    private fun fact(it: Int): BigInteger {
        if (it in factMap) {
            return factMap[it]!!
        }
        var ans = BigInteger.ONE
        for (i in 1..it) {
            ans *= i.toBigInteger()
            factMap[i] = ans
        }
        return ans
    }

    private fun check(cur: IntArray, balls: IntArray): Boolean {
        var a = 0
        var b = 0
        for (i in balls.indices) {
            if (cur[i] != 0) {
                a++
            }
            if (balls[i] - cur[i] != 0) {
                b++
            }
        }
        return a == b
    }
}