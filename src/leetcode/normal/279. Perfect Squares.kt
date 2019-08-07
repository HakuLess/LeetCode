package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    numSquares(12).print()
}

fun numSquares(n: Int): Int {
    val queue: Queue<Int> = LinkedList<Int>()
    val set = hashSetOf<Int>()
    var step = 0

    queue.add(0)
    set.add(0)
    while (queue.isNotEmpty()) {
        step++

        val size = queue.size
        for (i in 0 until size) {
            val cur = queue.poll()
            println("$step  $cur")
            if (cur == n) {
                return step - 1
            }
            var add = 1
            while (cur + add * add <= n) {
                if ((cur + add * add) !in set) {
                    queue.offer(cur + add * add)
                    set.add(cur + add * add)
                }
                add++
            }
        }
    }
    return -1
}