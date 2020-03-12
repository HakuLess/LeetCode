package leetcode.contest.last.c176

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5343()
    s.isPossible(intArrayOf(9, 3, 5)).print()
    s.isPossible(intArrayOf(29799, 253, 1, 4016, 1007, 1, 1, 1, 14936, 7528)).print()
    s.isPossible(intArrayOf(1, 100000000)).print()
}

class Solution5343 {
//    fun isPossible(target: IntArray): Boolean {
//        var max = 0
//        var index = 0
//        for (i in target.indices) {
//            if (max < target[i]) {
//                max = target[i]
//                index = i
//            }
//        }
//        if (max == 1) return true
//        for (i in target.indices) {
//            if (i == index) continue
//            if (target[i] > max) return false
//            max -= target[i]
//        }
//        target[index] = max
//        return isPossible(target)
//    }

    fun isPossible(target: IntArray): Boolean {
        val pq = PriorityQueue<Long>(compareByDescending { it })
        var sum = 0L
        target.forEach {
            pq.offer(it.toLong())
            sum += it
        }
        while (true) {
            val item = pq.poll() ?: 0L
            sum -= item
            if (item == 1L || sum == 1L) {
                return true
            }
            if (item < sum || sum == 0L || item % sum == 0L) {
                return false
            }
            pq.add(item % sum)
            sum += item % sum
        }
    }

//    fun helper(cur: IntArray, target: IntArray): Boolean {
//        if (!check(cur, target)) {
//            return false
//        }
//        cur.print()
//        if (cur.joinToString(",") == target.joinToString(",")) {
//            return true
//        }
//        val sum = cur.sum()
//        for (i in cur.indices) {
//            if (cur[i] == target[i]) {
//                continue
//            }
//            val temp = cur[i]
//            cur[i] = sum
//            if (helper(cur, target)) {
//                return true
//            }
//            cur[i] = temp
//        }
//        return false
//    }
//
//    private fun check(cur: IntArray, target: IntArray): Boolean {
//        for (i in cur.indices) {
//            if (cur[i] > target[i]) {
//                return false
//            }
//        }
//        return true
//    }
}