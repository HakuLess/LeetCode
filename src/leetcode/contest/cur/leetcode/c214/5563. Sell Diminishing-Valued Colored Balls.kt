package leetcode.contest.cur.leetcode.c214

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5563()
    s.maxProfit(intArrayOf(2, 5), 4).print()
//    s.maxProfit(intArrayOf(497978859, 167261111, 483575207, 591815159), 836556809).print()
//    s.maxProfit(intArrayOf(245604138, 167261111, 245604138, 245604138), 836556809).print()
}

class Solution5563 {

    fun maxProfit(inventory: IntArray, orders: Int): Int {
        val mod = 1000000007L
        inventory.sort()
        val l = inventory.size
        val inv = inventory.map { it.toLong() }
        var sum = inv.sum()
        var q = (sum - orders) / l
        var r = (sum - orders) % l
        var ans = 0L

        for (i in inv.indices) {
            if (inv[i] <= q) {
                sum -= inv[i]
                q = (sum - orders) / (l - i - 1)
                r = (sum - orders) % (l - i - 1)
            } else {
                if (r != 0L) {
                    q++
                    ans += (inv[i] - q) * (inv[i] + q + 1) / 2
                    ans %= mod
                    sum -= q
                    q = (sum - orders) / (l - i - 1)
                    r = (sum - orders) % (l - i - 1)
                } else {
                    sum -= q
                    ans += (inv[i] - q) * (inv[i] + q + 1) / 2
                    ans %= mod
                }
            }
        }
        return ans.toInt()
    }

//    fun maxProfit(inventory: IntArray, orders: Int): Int {
//        val sum = inventory.map { it.toLong() }.sum()
//        fun check(mid: Int): Boolean {
//            val n = inventory.map { if (it < mid) it.toLong() else mid.toLong() }.sum()
//            // println("$mid $sum ${sum - n} ${sum - n >= orders}")
//            return sum - n >= orders
//        }
//
//        val mod = 1000000007L
//        var left = 0
//        var right = inventory.max()!!
//        while (left + 1 < right) {
//            val mid = (left + right).ushr(1)
//            when {
//                check(mid) -> left = mid
//                else -> right = mid
//            }
//        }
//
//        left.print()
//        var l = orders
//        var res = 0L
//        inventory.forEach {
//            if (it > right) {
//                res += (it.toLong() + (right).toLong()) * (it - right + 1) / 2
//                l -= (it - right)
//            }
//            if (l == 0) return@forEach
//        }
//        if (l != 0)
//            res += l * (right - 1)
//        return (res % mod).toInt()
//    }
}