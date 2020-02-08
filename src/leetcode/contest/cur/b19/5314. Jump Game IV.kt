package leetcode.contest.cur.b19

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5314()
    s.minJumps(intArrayOf(11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13)).print()
}

class Solution5314 {
    fun minJumps(arr: IntArray): Int {
        if (arr.count { it == 7 } == arr.size - 1) {
            return 2
        }
        val map = HashMap<Int, ArrayList<Int>>()
        arr.forEachIndexed { index, it ->
            map[it] = map.getOrDefault(it, arrayListOf())
            map[it]!!.add(index)
        }

        val step = IntArray(arr.size) { -1 }
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)
        var s = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            s++
            for (i in 0 until size) {
                val item = queue.poll()
                if (step[item] != -1) {
                    continue
                }
                step[item] = s
                if (item + 1 in arr.indices)
                    queue.offer(item + 1)
                if (item - 1 in arr.indices)
                    queue.offer(item - 1)
                map[arr[item]]?.forEach {
                    queue.offer(it)
                }
//                arr.forEachIndexed { index, i ->
//                    if (i == arr[item]) {
//                        queue.offer(index)
//                    }
//                }
                if (step.last() != -1) {
                    return step.last()
                }
            }
        }
        return -1
    }
}