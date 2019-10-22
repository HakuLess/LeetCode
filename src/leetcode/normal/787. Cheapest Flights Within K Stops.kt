package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution787()
    s.findCheapestPrice(3, arrayOf(intArrayOf(0, 1, 100),
            intArrayOf(1, 2, 100),
            intArrayOf(0, 2, 500)), 0, 2, 1).print()
}

class Solution787 {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val dp = IntArray(n + 1) { -1 }
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(src, 0))
        var step = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            println(queue.size)
            if (step > K + 1) {
                break
            }
            step++
            for (i in 0 until size) {
                val item = queue.poll()
//                println("set ${item.first} is minOf ${dp[item.first]}, ${item.second}")
                if (dp[item.first] == -1 || dp[item.first] > item.second) {
//                    println("set ${item.first} is ${item.second}")
                    dp[item.first] = item.second
                    flights.filter {
                        it[0] == item.first
                    }.forEach {
//                        println("push ${it[1]} is ${item.second + it[2]}")
                        queue.offer(Pair(it[1], item.second + it[2]))
                    }
                }
            }
        }
        return dp[dst]
    }
}