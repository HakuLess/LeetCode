package leetcode.contest.b05

import leetcode.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5037()
    s.minimumSemesters(3,
            arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
            )).print()

    s.minimumSemesters(3,
            arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 1)
            )).print()
}

class Solution5037 {
    fun minimumSemesters(N: Int, relations: Array<IntArray>): Int {
        val pre = hashMapOf<Int, ArrayList<Int>>()
        for (i in 1..N) {
            pre[i] = arrayListOf()
        }
        relations.forEach {
            pre[it[1]]!!.add(it[0])
        }

        val seen = hashSetOf<Int>()
        val queue: Queue<Int> = LinkedList<Int>()
        pre.forEach {
            if (it.value.isEmpty()) {
                seen.add(it.key)
                queue.add(it.key)
            }
        }

        var step = 0
        while (queue.isNotEmpty()) {
            println(queue.size)
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                pre.forEach {
                    it.value.remove(item)
                }
            }

            pre.forEach {
                if (it.value.isEmpty() && it.key !in seen) {
                    seen.add(it.key)
                    queue.add(it.key)
                }
            }
        }

        return if (seen.size != N) {
            -1
        } else {
            step
        }
    }
}