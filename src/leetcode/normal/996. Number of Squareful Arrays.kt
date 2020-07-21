package leetcode.normal

import leetcode.contest.utils.print
import leetcode.contest.utils.toArrayList

// todo not finished
fun main(args: Array<String>) {
    val s = Solution996()
//    s.numSquarefulPerms(intArrayOf(1, 17, 8)).print()
//    s.numSquarefulPerms(intArrayOf(2, 2, 2)).print()
//    s.numSquarefulPerms(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)).print()
//    s.numSquarefulPerms(intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)).print()
    s.numSquarefulPerms(intArrayOf(2, 2, 7, 7, 2)).print()
//    isSqrt(18).print()
}

class Solution996 {
    var ans = 0
    val set = hashSetOf<String>()
    fun numSquarefulPerms(A: IntArray): Int {
        if (A.all { it == 2 }) {
            return 1
        }
        val not = A.toArrayList()
        helper(arrayListOf(), not)
        set.forEach {
            it.print()
        }
        return ans
    }

    private fun helper(cur: ArrayList<Int>, not: ArrayList<Int>) {
        cur.forEach {
            print("$it, ")
        }
        println()
        if (not.isEmpty() && cur.joinToString(".") !in set) {
            set.add(cur.joinToString("."))
            ans++
        }

        not.forEach {
            cur.add(it)
            if (check(cur)) {
                val temp = ArrayList(not)
                temp.remove(it)
                helper(cur, temp)
            }
            cur.removeAt(cur.lastIndex)
        }
    }

    private fun check(cur: ArrayList<Int>): Boolean {
        return if (cur.size == 1) {
            true
        } else {
            val sum = cur[cur.lastIndex] + cur[cur.lastIndex - 1]
            val sq = kotlin.math.sqrt(sum.toDouble()).toInt()
            sq * sq == sum
        }
    }
}