package leetcode.contest.cur.leetcode.c233

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5710()
//    s.getNumberOfBacklogOrders("[[10,5,0],[15,2,1],[25,1,1],[30,4,0]]".toGrid()).print()
    s.getNumberOfBacklogOrders("[[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]".toGrid()).print()
}

class Solution5710 {
    fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
        val buy = PriorityQueue<IntArray>(compareByDescending { it[0] })
        val sell = PriorityQueue<IntArray>(compareBy { it[0] })
        orders.forEach {
            if (it[2] == 0) {
                buy.offer(it)
            } else {
                sell.offer(it)
            }

            while (sell.isNotEmpty() && buy.isNotEmpty() && sell.peek()[0] <= buy.peek()[0]) {
                val sellItem = sell.poll()
                val buyItem = buy.poll()
                if (sellItem[1] == buyItem[1]) {
                    continue
                } else if (sellItem[1] > buyItem[1]) {
                    sell.offer(intArrayOf(sellItem[0], sellItem[1] - buyItem[1], sellItem[2]))
                } else {
                    buy.offer(intArrayOf(buyItem[0], buyItem[1] - sellItem[1], buyItem[2]))
                }
            }
        }
        val mod = 1000000007L
        var ans = 0L
        buy.forEach {
            ans += it[1]
        }
        sell.forEach {
            ans += it[1]
        }
        return (ans % mod).toInt()
    }
}