package leetcode

import java.util.HashSet
import java.util.ArrayList


fun main(args: Array<String>) {
    val s = Solution1015()
//    s.numDupDigitsAtMostN2(3999).print()
//    s.numDupDigitsAtMostN(3999).print()
//    s.numDupDigitsAtMostN(3794).print()
//    s.numDupDigitsAtMostN2(3794).print()
//    s.numDupDigitsAtMostN(3452).print()
//    s.numDupDigitsAtMostN2(3452).print()
//    s.numDupDigitsAtMostN(5421).print()
//    s.numDupDigitsAtMostN2(5421).print()
//    s.numDupDigitsAtMostN(4091).print()
//    s.numDupDigitsAtMostN2(4091).print()
    s.numDupDigitsAtMostN(3444).print()
    s.numDupDigitsAtMostN2(3444).print()
//    s.numDupDigitsAtMostN(999999).print()
//    s.numDupDigitsAtMostN(9999999).print()
//    s.numDupDigitsAtMostN(99999999).print()
//    s.numDupDigitsAtMostN(999999999).print()
//    s.A(7, 3).print()
}

class Solution1015 {

    fun numDupDigitsAtMostN(N: Int): Int {
        // Transform N + 1 to arrayList
        val l = ArrayList<Int>()
        var x = N + 1
        while (x > 0) {
            l.add(0, x % 10)
            x /= 10
        }

        // Count the number with digits < N (starts with zero)
        var res = 0
        val n = l.size
        for (i in 1 until n) {
            res += 9 * A(9, i - 1)
            println(res)
        }

        // Count the number with same length
        val seen = HashSet<Int>()
        for (i in 0 until n) {
            for (j in (if (i > 0) 0 else 1) until l[i]) {
                if (!seen.contains(j)) {
                    res += A(9 - i, n - i - 1)
                    println("${9 - i}, ${n - i - 1} : $res")
                }
            }

            if (seen.contains(l[i])) {
                break
            }
            seen.add(l[i])
        }
        return N - res
    }


    fun A(m: Int, n: Int): Int {
        return if (n == 0) 1 else A(m, n - 1) * (m - n + 1)
    }

//    fun numDupDigitsAtMostN(N: Int): Int {
//        val size = N.toString().length
//        var ans = 0
//        val s = intArrayOf(0, 9, 261, 4725, 67509, 831429, 9287109, 97654149, 994388229)
//        val s0 = intArrayOf(0, 1, 28, 496, 6976, 84880, 939520, 9818560, 99637120)
//        val n = N.toString()
//        var str = ""
//
//        for (i in 0 until size) {
//            val c = Integer.parseInt(n[i].toString())
//
//            ans += c * s0[size - i - 1]
//            println("$c, ${s0[size - i - 1]}")
//        }
//
//        return ans
//
//    }

    fun numDupDigitsAtMostN2(N: Int): Int {
        var ans = 0
        for (i in 1..N) {
            if (cal(i)) {
                ans++
            }
        }
        return ans
    }

    private fun cal(N: Int): Boolean {
        var n = N
        val ans = IntArray(10)
        while (n >= 1) {
            ans[n % 10]++
            if (ans[n % 10] > 1) {
                return true
            }
            n /= 10
        }
        return false
    }
}