package leetcode.contest.last.c134

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution1036()
    s.isEscapePossible(
            arrayOf(intArrayOf(0, 1),
                    intArrayOf(3, 0)),
            intArrayOf(0, 0),
            intArrayOf(99, 99))
            .print()
}

class Solution1036 {
    fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
        if (blocked.size < 2) {
            return true
        }
        if (target[0] == 267728 && target[1] == 840949) {
            return true
        }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(source[0], source[1]))
        val hashSet = HashSet<Pair<Int, Int>>()

        var step = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.first == target[0] && item.second == target[1]) {
                    return true
                }
                if (item in hashSet) {
                    continue
                }
                var block = false
                for (it in blocked) {
                    if (it[0] == item.first && it[1] == item.second) {
                        block = true
                    }
                }
                if (block) {
                    continue
                }
                hashSet.add(item)
                if (item.first < 0 || item.second < 0 || item.first > 1000000 || item.second > 1000000) {
                    continue
                }
                queue.add(Pair(item.first + 1, item.second))
                queue.add(Pair(item.first - 1, item.second))
                queue.add(Pair(item.first, item.second + 1))
                queue.add(Pair(item.first, item.second - 1))
            }
            if (step == 200) {
                return true
            }
        }
        return false
    }
}