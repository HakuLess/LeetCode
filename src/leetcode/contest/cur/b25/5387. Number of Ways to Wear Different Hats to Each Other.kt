package leetcode.contest.cur.b25

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.set


fun main(args: Array<String>) {
    val s = Solution5387()
//    s.numberWays(listOf(
//            listOf(3, 4),
//            listOf(4, 5),
//            listOf(5)
//    )).print()

    s.numberWays(listOf(
            listOf(4, 15, 16, 26, 28),
            listOf(1, 2, 3, 4, 6, 7, 8, 10, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 25, 27, 28, 29, 30),
            listOf(1, 2, 3, 4, 5, 7, 9, 10, 11, 12, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30),
            listOf(2, 3, 6, 7, 14, 16, 17, 18, 19, 20, 21, 24, 25, 27, 28, 29),
            listOf(1, 10),
            listOf(1, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 19, 20, 21, 22, 24, 25, 27, 28),
            listOf(2, 5, 10, 14, 16, 19, 21, 22, 23, 27, 30)
    )).print()

//    s.numberWays(listOf(
//            listOf(1, 2, 3, 4),
//            listOf(1, 2, 3, 4),
//            listOf(1, 2, 3, 4),
//            listOf(1, 2, 3, 4)
//    )).print()

//    s.numberWays(listOf(
//            listOf(1, 2, 3),
//            listOf(2, 3, 5, 6),
//            listOf(1, 3, 7, 9),
//            listOf(1, 8, 9),
//            listOf(2, 5, 7)
//    )).print()
}

class Solution5387 {

    val mod = 1000000007
    val meet = HashMap<String, Int>()
    var allmask = 0
    var t = 0
    fun numberWays(hats: List<List<Int>>): Int {
        val adj: Array<ArrayList<Int>> = Array<ArrayList<Int>>(41) { arrayListOf() }
        val n: Int = hats.size
        for (i in 0 until n) {
            for (j in hats[i]) {
                adj[j - 1].add(i)
            }
        }
        allmask = (1 shl n) - 1
        return helper(0, 0, adj.toList())
    }

    private fun helper(cur: Int, mask: Int, hats: List<List<Int>>): Int {
        if (cur > 40) {
            return 0
        }
        if (mask == allmask) {
            return 1
        }
        val key = "$cur $mask"
        if (key in meet) {
            return meet[key]!!
        }
        var ans = 0
        ans = (ans + helper(cur + 1, mask, hats)) % mod
        hats[cur].forEach {
            if (mask and (1 shl it) == 0) {
                ans = (ans + helper(cur + 1, mask or (1 shl it), hats)) % mod
            }
        }
        meet[key] = ans
        t++
        println("$t : $key, $ans ")
        return ans
    }
}