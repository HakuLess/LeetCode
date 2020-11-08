package leetcode.contest.cur.leetcode.c214

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5563()
//    s.maxProfit(intArrayOf(2, 5), 4).print()
    s.maxProfit(intArrayOf(497978859, 167261111, 483575207, 591815159), 836556809).print()
//    s.maxProfit(intArrayOf(245604138, 167261111, 245604138, 245604138), 836556809).print()
}

class Solution5563 {
    fun maxProfit(inventory: IntArray, orders: Int): Int {
        val mod = 1000000007L
        inventory.sort()

        fun pick(num: Int): Long {
            var p = 0L
            for (i in inventory) {
                if (i > num)
                    p += i - num
            }
            return p
        }

        fun cal(div: Int): Long {
            var ans = 0L
            for (item in inventory) {
                if (item > div)
                    ans += (item + div + 1) * (item - div).toLong() / 2
            }
            val pb = pick(div)
            val remain = orders - pb
            return if (remain == 0L) {
                ans % mod
            } else {
                ans += remain * div.toLong()
                ans % mod
            }
        }

        var left = 0
        var right = inventory.max()!!
        var divider = 0
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            val balls = pick(mid)
            if (balls == orders.toLong()) {
                divider = mid
                break
            } else if (balls < orders) {
                right = mid
            } else {
                left = mid
            }
        }
        return if (divider > 0)
            cal(divider).toInt()
        else
            cal(right).toInt()
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