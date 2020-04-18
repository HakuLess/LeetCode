package leetcode.contest.cur.`2020`.q1

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solutionq2()
    s.numWays(5,
            arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(2, 1),
                    intArrayOf(3, 4),
                    intArrayOf(2, 3),
                    intArrayOf(1, 4),
                    intArrayOf(2, 0),
                    intArrayOf(0, 4)
            ),
            3).print()
}

class Solutionq2 {
    fun numWays(n: Int, relation: Array<IntArray>, k: Int): Int {
        val map = HashMap<Int, ArrayList<Int>>()
        relation.forEach {
            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
            map[it[0]]!!.add(it[1])
        }

        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)
        var step = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            if (step == k) {
                return queue.filter { it == n - 1 }.size
            }
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (map[item] != null) {
                    map[item]!!.forEach {
                        println("$item add $it")
                        queue.offer(it)
                    }
                }
            }
        }
        return 0
    }
}