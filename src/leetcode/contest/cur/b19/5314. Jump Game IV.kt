package leetcode.contest.cur.b19

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5314()
    s.minJumps(intArrayOf(11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13)).print()
}

class Solution5314 {
//    fun minJumps(arr: IntArray): Int {
//        val map = HashMap<Int, HashSet<Int>>()
//        arr.forEachIndexed { index, it ->
//            map[it] = map.getOrDefault(it, hashSetOf())
//            map[it]!!.add(index)
//        }
//        val queue: Queue<Int> = LinkedList<Int>()
//        queue.add(0)
//        val visited = BooleanArray(arr.size)
//
//        var count = 0
//        while (!queue.isEmpty()) {
//            val size = queue.size
//            for (i in 0 until size) {
//                val head = queue.poll()
//                if (head == arr.size - 1) {
//                    return count
//                } else if (head in arr.indices && !visited[head]) {
//                    visited[head] = true
//                    queue.add(head - 1)
//                    queue.add(head + 1)
//                    for (j in map[arr[head]]!!) {
//                        queue.add(j)
//                    }
//                    map[arr[head]]!!.clear()
//                }
//            }
//            count++
//        }
//
//        return -1
//    }

    fun minJumps(arr: IntArray): Int {
        val map = HashMap<Int, HashSet<Int>>()
        arr.forEachIndexed { index, it ->
            map[it] = map.getOrDefault(it, hashSetOf())
            map[it]!!.add(index)
        }

        val seen = BooleanArray(arr.size) { false }
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)
        var s = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            s++
            for (i in 0 until size) {
                val item = queue.poll()
                if (item == arr.lastIndex) {
                    return s
                }
                if (seen[item]) {
                    continue
                }
                seen[item] = true
                if (item + 1 in arr.indices)
                    queue.offer(item + 1)
                if (item - 1 in arr.indices)
                    queue.offer(item - 1)
                map[arr[item]]?.forEach {
                    queue.offer(it)
                }
                map[arr[item]]?.clear()
            }
        }
        return -1
    }
}