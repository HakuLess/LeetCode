package leetcode.contest.cur.`2020`.q2

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solutionq2()
//    s.splitArray(intArrayOf(2, 3, 3, 2, 3, 3)).print()
//    s.splitArray(intArrayOf(2, 3, 5, 7)).print()
    s.splitArray(intArrayOf(13, 23, 34, 47, 46)).print()
}

class Solutionq2 {
    var num = intArrayOf()

    val seen = HashMap<Int, Int>()

    fun splitArray(nums: IntArray): Int {
        num = nums
        return helper(0)
    }

    private fun helper(cur: Int): Int {
        if (cur > num.lastIndex) {
            return 0
        }
        if (cur in seen) {
            return seen[cur]!!
        }
        var ans = 0
        for (i in cur..num.lastIndex) {
            if (gcd(num[cur], num[i]) > 1) {
                ans = if (ans == 0) {
                    helper(i + 1) + 1
                } else {
                    minOf(ans, helper(i + 1)) + 1
                }
            }
        }
        seen[cur] = ans
        return ans
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}