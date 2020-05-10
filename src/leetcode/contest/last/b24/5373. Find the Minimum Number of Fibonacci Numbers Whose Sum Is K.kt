package leetcode.contest.last.b24

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5373()
    s.findMinFibonacciNumbers(19).print()
}

class Solution5373 {

    fun calcFiboTerms(fiboterms: ArrayList<Int>, k: Int) {
        var i = 3
        var nextTerm = 0
        fiboterms.add(0)
        fiboterms.add(1)
        fiboterms.add(1)
        while (true) {
            nextTerm = fiboterms[i - 1] + fiboterms[i - 2]
            if (nextTerm > k) return
            fiboterms.add(nextTerm)
            i++
        }
    }

    fun findMinFibonacciNumbers(k: Int): Int {
        var k = k
        val fiboterms = ArrayList<Int>()
        calcFiboTerms(fiboterms, k)
        var count = 0
        var j = fiboterms.size - 1

        while (k > 0) {
            count += k / fiboterms[j]
            k %= fiboterms[j]
            j--
        }
        return count
    }
}